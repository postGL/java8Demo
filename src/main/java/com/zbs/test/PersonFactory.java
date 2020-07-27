package com.zbs.test;

/**
 * description: PersonFactory
 * date: 2020/7/10 10:29
 * author: zhangbs
 * version: 1.0
 */
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
