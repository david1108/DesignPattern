/**
 *一、什么是反射？
 * 在运行状态中，对于任意一个类，都能够获取到这个类的所有属性和方法，对于任意一个对象，都能够调用它的任意一个方法和属性(包括私有的方法和属性)，这种动态获取的信息以及动态调用对象的方法的功能就称为java语言的反射机制。通俗点讲，通过反射，该类对我们来说是完全透明的，想要获取任何东西都可以。
 * 想要使用反射机制，就必须要先获取到该类的字节码文件对象(.class)，通过字节码文件对象，就能够通过该类中的方法获取到我们想要的所有信息(方法，属性，类名，父类名，实现的所有接口等等)，每一个类对应着一个字节码文件也就对应着一个Class类型的对象，也就是字节码文件对象。
 * 获取字节码文件对象的三种方式。
 *
 * 1、Class clazz1 = Class.forName("全限定类名");　　//通过Class类中的静态方法forName，直接获取到一个类的字节码文件对象，此时该类还是源文件阶段，并没有变为字节码文件。
 * 2、Class clazz2  = Person.class;　　　　//当类被加载成.class文件时，此时Person类变成了.class，在获取该字节码文件对象，也就是获取自己， 该类处于字节码阶段。
 * 3、Class clazz3 = p.getClass();　　　　//通过类的实例获取该类的字节码文件对象，该类处于创建对象阶段　
 * 有了字节码文件对象才能获得类中所有的信息，我们在使用反射获取信息时，也要考虑使用上面哪种方式获取字节码对象合理，视不同情况而定。下面介绍Class类的功能。
 */

package org.david.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class ReflectExample {
    /**
     * 二、反射机制能够获取哪些信息？Class类的API详解。
     * 2.1、通过字节码对象创建实例对象
     */
    public void getByteCode()throws Exception{

        ReflectTargetClass reflectTargetClass = new ReflectTargetClass();

        Class clazz1 = Class.forName("org.david.reflect.ReflectTargetClass");

        Class clazz2 = ReflectTargetClass.class;

        Class clazz3 = reflectTargetClass.getClass();

        ReflectTargetClass reflectTargetClass1 = (ReflectTargetClass)clazz1.newInstance();

        ReflectTargetClass reflectTargetClass2 = (ReflectTargetClass)clazz2.newInstance();

        ReflectTargetClass reflectTargetClass3 = (ReflectTargetClass)clazz3.newInstance();


        System.out.println("clazz3.getFields().length:"+ clazz3.getFields().length);
        System.out.println("clazz3.getDeclaredFields().length:"+ clazz3.getDeclaredFields().length);

        System.out.println(reflectTargetClass1);
        System.out.println(reflectTargetClass2);
        System.out.println(reflectTargetClass3);

    }

    public void getConstructor() throws Exception{

        ReflectTargetClass reflectTargetClass = new ReflectTargetClass();

        Class clazz1 = Class.forName("org.david.reflect.ReflectTargetClass");

        //2.1 获取指定构造器方法。获取无参构造器 constructor 如果没有无参构造，只有有参构造如何创建实例呢？看下面
        Constructor constructor1 = clazz1.getConstructor();
        //2.2 获取指定构造器方法。获取有参构造器
        Constructor constructor2 = clazz1.getConstructor(String.class,int.class);

        ReflectTargetClass reflectTargetClass1 = (ReflectTargetClass)constructor1.newInstance();
        ReflectTargetClass reflectTargetClass2 = (ReflectTargetClass)constructor2.newInstance("field-",10);

        System.out.println(reflectTargetClass1);

        System.out.println(reflectTargetClass2);

    }

    public void getAllConstructor() throws Exception{

        ReflectTargetClass reflectTargetClass = new ReflectTargetClass();

        Class clazz1 = Class.forName("org.david.reflect.ReflectTargetClass");

        //2.1 获取所有构造器
        Constructor[] constructors1 = clazz1.getConstructors();

        for (Constructor constructor :constructors1){



            Class[] parameterTypes = constructor.getParameterTypes();

            //Object[] parameter = new Object[parameterTypes.length];

            for(Class clazz:parameterTypes){

                System.out.println("clazz.getName(): "+clazz.getName());

                System.out.println("clazz.getSimpleName(): "+clazz.getSimpleName());

                System.out.println("clazz.getTypeName(): "+ clazz.getTypeName());

            }

            Parameter[] parameters = constructor.getParameters();

            for(Parameter parameter:parameters){

                System.out.println("parameter.getName(): "+ parameter.getName());

            }

        }

    }



    public static void main(String[] args) throws Exception{


        ReflectExample reflectExample = new ReflectExample();

        reflectExample.getByteCode();

        //example1.getConstructor();

        //example1.getAllConstructor();


    }
}
