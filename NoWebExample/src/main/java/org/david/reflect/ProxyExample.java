package org.david.reflect;

public class ProxyExample {

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        ProxyTargetClass proxyTargetClass = new ProxyTargetClass();
        IProxy proxy1  = proxy.getInstance(proxyTargetClass);
        proxy1.method3(123);
    }
}
