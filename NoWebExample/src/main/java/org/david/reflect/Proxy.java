package org.david.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy implements InvocationHandler {

    private IProxy target;
    public IProxy getInstance(IProxy target){
        this.target = target;
        Class<?> clazz =  target.getClass();
        return (IProxy) java.lang.reflect.Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target,args);
        after();
        return result;
    }

    private void after() {
        System.out.println("after");
    }

    private void before() {
        System.out.println("before");
    }
}
