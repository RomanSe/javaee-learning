package ru.semenov.services;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MethodLogger {
    @AroundInvoke
    public Object printLog(InvocationContext ctx) throws Exception{
        System.out.println("Method invoked: " + ctx.getMethod().getName() + " " + ctx.getParameters());
        return ctx.proceed();
    }
}