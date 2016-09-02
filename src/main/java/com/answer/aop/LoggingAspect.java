package com.answer.aop;

import com.answer.util.JacksonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import static java.lang.System.out;

/**
 * Created by Administrator on 2016/9/1.
 */

public class LoggingAspect {


    public void before(JoinPoint point) {
        out.print(LoggingAspect.class.getSimpleName()+"-");
        out.print(point.getTarget().getClass().getSimpleName()+".");
        out.print(point.getSignature().getName()+"-begin-args-");
        try {
            out.print(JacksonUtil.toJson(point.getArgs()));
        } catch (Throwable e) {
            // TODO: handle exception
            out.print("[");
            for (Object object : point.getArgs()) {
                out.print(object+",");
            }
            out.print("\b]");
        }
        out.println();
    }

    public void after(JoinPoint point) {
        out.print(LoggingAspect.class.getSimpleName()+"-");
        out.print(point.getTarget().getClass().getSimpleName()+".");
        out.print(point.getSignature().getName()+"-after-");
        out.println();
    }

    public void returned(JoinPoint point,Object result) {
        out.print(LoggingAspect.class.getSimpleName()+"-");
        out.print(point.getTarget().getClass().getSimpleName()+".");
        out.print(point.getSignature().getName()+"-returned-result-");
        out.print((result instanceof String)?result:JacksonUtil.toJson(result));
        out.println();
    }

    public void throwed(JoinPoint point,Throwable ex) {
        out.print(LoggingAspect.class.getSimpleName()+"-");
        out.print(point.getTarget().getClass().getSimpleName()+".");
        out.print(point.getSignature().getName()+"-throwed-ex-");
        out.print(ex.getMessage()+"-"+ex.getClass().getSimpleName());
        out.println();
    }
}
