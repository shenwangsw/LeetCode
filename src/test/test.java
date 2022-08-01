package test;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        //运行时多态
        SuperClass clazz = new SubClass();
        //SubClass clazz = new SubClass();
        //执行的是子类的方法
        clazz.method();
        //执行的是父类中的方法
        clazz.method2();
        //子类新增的方法：报错
        //clazz.method1();
        //相同属性：调用父类的属性值
        System.out.println(clazz.str);
        //子类新增属性:报错
        //System.out.println(clazz.sonInt);
        //静态方法：执行父类中的方法
        clazz.method3();
    }


}
class SuperClass{
    static int superInt = 1;
    String str = "father";
    public SuperClass(){
        System.out.println("父类的构造方法");
    }
    public void method(){
        System.out.println("父类的method()");
    }
    public void method2(){
        System.out.println("父类method2");
    }
    public static void method3(){
        System.out.println("父类static method3()");
    }
}
class SubClass extends SuperClass{
    public SubClass(){
        System.out.println("子类的构造方法");
    }
    static int superInt =2;
//    String str = "Son";
    int sonInt =1;
    @Override
    public void method() {

        System.out.println("子类的method");
    }


    public void method1() {
        System.out.println("子类的method1");
    }

    public static void method3() {
        System.out.println("子类的method3");
    }

}
