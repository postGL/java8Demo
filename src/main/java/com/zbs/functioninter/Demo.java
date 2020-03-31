package com.zbs.functioninter;

/**
 * description: Demo 函数式接口例子
 * date: 2020/3/31 14:33
 * author: zbs
 * version: 1.0
 *
 * 函数式接口的使用：一般可以作为参数和返回值使用
 */
public class Demo {
    public static void show(InterfaceEntry interfaceEntry){
        interfaceEntry.simplePrint();
        System.out.println("函数式接口使用");
    }

    public static void main(String[] args) {
        //调用show()方法，参数是个接口，可以传递一个实现类
        show(new InterfaceEntryImpl());

        //调用show()方法，参数是个接口，可以传递接口的匿名内部类
    }
}
