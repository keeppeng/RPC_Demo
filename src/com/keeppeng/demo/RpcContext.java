package com.keeppeng.demo;

import java.io.Serializable;

public class RpcContext implements Serializable {
    private String className;//调用的类名
    private String methodName;//调用的方法名
    private Class[] types;//请求参数类型
    private Object[] params;//请求参数

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class[] getTypes() {
        return types;
    }

    public Object[] getParams() {
        return params;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
