package org.david.reflect;

public class ProxyTargetClass implements IProxy{

    private String field1= "field1";
    private int field2= 2;
    private double field3= 3.3;

    public String field4 = "field4";

    public int field5= 5;

    public ProxyTargetClass(String field1, int field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public ProxyTargetClass() {

    }

    public void method1(){

        System.out.println("没有参数,没有返回值的方法");

    }
    public int method2(){

        System.out.println("没有参数，有返回值的方法");
        return 1;

    }
    public int method3(int a){

        System.out.println("有参数，有返回值的方法");

        return 2*a;

    }

    @Override
    public String toString() {
        return "ReflectTestClass{" +
                "field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3=" + field3 +
                '}';
    }
}
