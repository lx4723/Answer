package com.answer.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2016/9/5.
 */
public class RedisConfig {
    private static String ip;
    private static int port;
    private static int maxActive;
    private static int maxIdle;
    private static long maxWait;
    private static long timeOut;

    private  RedisConfig(){

    }
    static {
        Properties pro = new Properties();

        InputStream inputStream = RedisConfig.class.getResourceAsStream("/RedisConfig.properties");

        try {
            pro.load(inputStream);
            ip=pro.getProperty("ip").trim();
            port=Integer.parseInt(pro.getProperty("port").trim());
            maxActive=Integer.parseInt(pro.getProperty("maxActive").trim());
            maxIdle=Integer.parseInt(pro.getProperty("maxIdle").trim());
            maxWait=Long.parseLong(pro.getProperty("maxWait").trim());
            timeOut=Long.parseLong(pro.getProperty("timeOut").trim());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("关闭失败");
            }

        }
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        RedisConfig.ip = ip;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        RedisConfig.port = port;
    }

    public static int getMaxActive() {
        return maxActive;
    }

    public static void setMaxActive(int maxActive) {
        RedisConfig.maxActive = maxActive;
    }

    public static int getMaxIdle() {
        return maxIdle;
    }

    public static void setMaxIdle(int maxIdle) {
        RedisConfig.maxIdle = maxIdle;
    }

    public static long getMaxWait() {
        return maxWait;
    }

    public static void setMaxWait(long maxWait) {
        RedisConfig.maxWait = maxWait;
    }

    public static long getTimeOut() {
        return timeOut;
    }

    public static void setTimeOut(long timeOut) {
        RedisConfig.timeOut = timeOut;
    }
}
