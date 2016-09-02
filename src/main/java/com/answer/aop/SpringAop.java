package com.answer.aop;


import com.answer.util.CustomException;
import com.answer.util.ResultUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/9/1.
 */

@Aspect
@Component
public class SpringAop {

    /**
     * 指定切入点匹配表达式，注意它是以方法的形式进行声明的。
     */
    @Pointcut("execution(* com.answer.controller.*.*(..))")
    public void anyMethod() {
    }

    /**
     * 前置通知
     *
     * @param jp
     */
    @Before(value = "execution(* com.answer.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws Exception{
        // String token = jp.getArgs()[0].toString();
    }

    /**
     * 后置通知
     *
     * @param jp     连接点
     * @param result 返回值
     */
    @AfterReturning(value = "anyMethod()", returning = "result")
    public void doAfter(JoinPoint jp, String result) {
    }

    /**
     * 环绕通知
     * value = "execution(* com.answer.controller.*.*(..))"第一个*比表示方法的类型以及返回的类型
     *
     * @param pjp 连接点
     */
    @Around(value = "execution(Object com.answer.controller.*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return new ResultUtil(true, ResultUtil.SUCCESS, pjp.proceed());
        } catch (CustomException e) {
            e.printStackTrace();
            return new ResultUtil(false, e.getCode(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultUtil(false, ResultUtil.ERROR, "系统异常");
        }
    }

    /**
     * 异常通知
     *
     * @param jp
     * @param e
     */
    @AfterThrowing(value = "execution(* com.answer.controller.*.*(..))", throwing = "e")
    public void doThrow(JoinPoint jp, Throwable e) {
    }
}
