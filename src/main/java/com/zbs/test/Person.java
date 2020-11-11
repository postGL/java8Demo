package com.zbs.test;

import java.time.LocalDate;

/**
 * description: Person
 * date: 2020/7/10 10:09
 * author: zhangbs
 * version: 1.0
 */
public class Person {
    String firstName;
    String lastName;
    LocalDate birthday;

//    public Person() {
//        System.out.println("我的构造。。。");
//    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
