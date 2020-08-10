package com.keeppeng.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationHandler implements InvocationHandler {

    private Class interfaces;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcContext rpcContext = new RpcContext();
        rpcContext.setClassName(interfaces.getName());
        rpcContext.setMethodName(method.getName());
        rpcContext.setTypes(method.getParameterTypes());
        rpcContext.setParams(args);

        return Client.getInstance().invokeServer(rpcContext);
    }
}
