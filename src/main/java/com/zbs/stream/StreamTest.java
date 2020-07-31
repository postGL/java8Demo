package com.zbs.stream;

import com.zbs.functioninter.InterfaceEntry;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * description: StreamTest
 * date: 2020/7/28 14:03
 * author: zhangbs
 * version: 1.0
 * 文章：https://blog.csdn.net/xxssyyyyssxx/article/details/50148169
 * 最常用的14个Stream：https://www.toutiao.com/i6805004400730309134/
 * JSK1.8文档
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        InterfaceEntry interfaceEntry = System.out::println;
        // filter过滤、forEach遍历
        //stringCollection.stream().filter((s) -> s.startsWith("b")).forEach(System.out::println);

        // sorted进行排序
        //stringCollection.stream().sorted((s1, s2) -> s1.compareTo(s2)).forEach(System.out::println);
        //stringCollection.stream().sorted(String::compareTo).forEach(System.out::println);

        //Map 映射转换对象
        stringCollection.stream().map(s -> s + "_zbs").forEach(System.out::println);
        stringCollection.stream().map(s -> s + "_zbs").collect(Collectors.toList()).forEach(System.out::println);

        //Match 匹配
//        testMatch(stringCollection);

        //count计数
//        long num = stringCollection.stream().filter(s -> s.startsWith("b")).count();
//        System.out.println(num);
    }

    public static void testMatch(List<String> stringCollection) {
        //Match 匹配
        // 任意匹配
        boolean anyStartsWithA = stringCollection.stream().anyMatch(s -> s.startsWith("a"));
        System.out.println(anyStartsWithA);
        // 全部匹配
        boolean allStartsWithA = stringCollection.stream().allMatch(s -> s.startsWith("a"));
        System.out.println(allStartsWithA);
        // 不匹配
        boolean noneStartsWithA = stringCollection.stream().noneMatch(s -> s.startsWith("a"));
        System.out.println(noneStartsWithA);
    }

    @Test
    public void testOptional() {
        // Optional 接口
        List<String> collection = new ArrayList<>();
        // 判断是否为null，存在：true
        System.out.println(Optional.of(collection).isPresent());

        // 判断是否为空，不是空就赋值，是空就赋值else得内容
        collection = null;
        List<String> collectionResult;
        collectionResult = Optional.ofNullable(collection).orElse(Arrays.asList("collection是null"));
        System.out.println(collectionResult);

        // ifPresent[if (value != null) consumer.accept(value)]
        Optional<String> optional = Optional.of("bam");
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }

    @Test
    public void testSupplier() {
        // 示例1
        int num1 = 100;
        int num2 = 200;
        // 提前定义好需要返回的指定类型结果，但不运行
        Supplier<Integer> supplier = () -> num1 + num2;
        // 调取get()方法获取一个结果
        System.out.println(supplier.get());
        //【Supplier：供给型函数式接口使用了(局部变量)num1】num1默认为final，不可以更改
        //num1 = 300;
    }

    @Test
    public void testConsumer() {
        // 示例1
        int num1 = 100;
        // 提前定义好需要返回的指定类型结果，但不运行
        Consumer<Integer> consumer = (num) -> System.out.println((num1 + num));
        consumer.accept(10);
    }
}
