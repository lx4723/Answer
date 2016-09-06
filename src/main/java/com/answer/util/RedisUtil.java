package com.answer.util;

import com.answer.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * Created by Administrator on 2016/9/5.
 */

public class RedisUtil {
    private static final Log log= LogFactory.getLog(RedisUtil.class);

    private static JedisPool pool;

    private static JedisPoolConfig config=new JedisPoolConfig();

    /**
     * 构建jedis连接池
     * @return
     */
    public static  JedisPool getPool(){
       if(pool!=null){
           config.setMaxTotal(RedisConfig.getMaxActive());
           config.setMaxIdle(RedisConfig.getMaxIdle());
           config.setMaxWaitMillis(RedisConfig.getMaxWait());
           pool = new JedisPool(config,RedisConfig.getIp(),RedisConfig.getPort());
       }
        return  pool;
   }

    /**
     * 回收jedis
     * @param jedis
     */
   public static void returnResource(Jedis jedis){
       if(jedis != null){
           pool.returnResource(jedis);
       }
   }

    /**
     * 存储登陆人和用户标示token
     * @param token
     * @param user
     */
    public static void saveUser(String token,User user){
        Jedis jedis = null;

        String  loginName=user.getEmail();
        try{
            //获得jedis链接
            jedis=getPool().getResource();
            String key=jedis.get(loginName);

            if(key != null){
                jedis.del(key);

                jedis.set(token, JsonUtil.toJson(user));
                jedis.pexpire(token, RedisConfig.getTimeOut());
                jedis.set(loginName,token);
                jedis.pexpire(loginName, RedisConfig.getTimeOut());
            }else{
                jedis.set(token,JsonUtil.toJson(user));
                jedis.pexpire(token, RedisConfig.getTimeOut());
                jedis.set(loginName,token);
                jedis.pexpire(loginName, RedisConfig.getTimeOut());
            }

        }catch(Exception e){
            log.error(e);
            e.printStackTrace();
        }finally {
            RedisUtil.returnResource(jedis);
        }

    }

}
