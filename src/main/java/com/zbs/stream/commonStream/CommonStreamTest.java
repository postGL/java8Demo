package com.zbs.stream.commonStream;

import com.zbs.test.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * description: CommonStreamTest
 * date: 2020/7/31 16:40
 * author: zhangbs
 * version: 1.0
 */
public class CommonStreamTest {

    /**
     * forEach 遍历
     */
    @Test
    public void forEachTest() {
        Collection<String> strCollection = Arrays
                .asList("you", "don`t", "bird", "me", ",", "i", "don`t", "bird", "you");
        strCollection.stream().forEach(System.out::println);
    }

    /**
     * filter 过滤
     */
    @Test
    public void filterTest() {
        List<User> userList = Arrays.asList(
                new User(1L, "mengday", 28),
                new User(2L, "guoguo", 18),
                new User(3L, "liangliang", 17)
        );
        userList.stream().filter(user -> user.getAge() > 18).forEach(System.out::println);
        System.out.println("=======分割输出======");
        Consumer<User> consumer = System.out::println;
        for (User user : userList) {
            //证明filter只是暂时过滤，不改变原userList
            consumer.accept(user);
        }
    }

    /**
     * map 映射对象，更改对象
     */
    @Test
    public void mapTest() {
        List<String> list = Arrays.asList("how", "are", "you", "how", "old", "are", "you", "?");
        list.stream().map(str -> {
            str += "_zbs";
            return str.toUpperCase();
        }).forEach(System.out::println);
    }

    @Test
    public void flatMapTest() {

    }
}

