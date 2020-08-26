package com.zbs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * description: FunctionTest2
 * date: 2020/7/30 14:22
 * author: zhangbs
 * version: 1.0
 */
public class TestDemo {

    @org.junit.Test
    public void testSplit() {
        List<String> strList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //s -> "[]"
            String s = objectMapper.writeValueAsString(strList);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static void consumeString(Consumer<String> one, Consumer<String> two) {
        one.andThen(two).accept("Hello");
    }

    @org.junit.Test
    public void testAndThen() {
        consumeString(
                s -> System.out.println(s.toUpperCase()),
                s -> System.out.println(s)
        );
    }
}

