package com.zbs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

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

    @Test
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

    @Test
    public void testAndThen() {
        consumeString(
                s -> System.out.println(s.toUpperCase()),
                s -> System.out.println(s)
        );
    }

    @Test
    public void testString() {
//        String str = "[{\"name\":\"单行输入框\",\"defaultLabel\":\"单行输入框\",\"defaultProps\":\"请输入\",\"defaultImportant\":false,\"defaultPrint\":false,\"componentName\":\"textfield\",\"supportSetting\":[\"label\",\"placeholder\",\"required\",\"important\",\"print\"],\"idx\":1}]";

        // String str1 = "[]"; // 不会报异常

        String str = ""; // 会报异常
        ObjectMapper objectMapper = new ObjectMapper();
        List<FlowFormField> tableSonComponentList = new ArrayList<>();
        try {
            tableSonComponentList = objectMapper.readValue(str,
                    new TypeReference<List<FlowFormField>>() {
                    });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(tableSonComponentList);
    }

    @Test
    public void testObjectUtils() {
        String s2 = "  ";
        System.out.println(s2.length());

//        ObjectUtils 是指springFrameWork的包
//        // 是空
//        String s1 = "";
//        if (!ObjectUtils.isEmpty(s1)) {
//            System.out.println("s1不是空");
//        }
//        // 不是空
//        String s2 = "  ";
//        if (!ObjectUtils.isEmpty(s2)) {
//            System.out.println("s1不是空");
//        }
    }

    /**
     * replaceAll、replace 必须用新的子浮串接收才能获取新的替换值
     */
    @Test
    public void testReplace() {
        String str = "2018.05.12.18";
        String s = str.replaceAll("[\\pP\\pS\\pZ\\pC]", "-");
        System.out.println(s);

        str.replaceAll("18", "-");
        System.out.println(str);

        str.replace("18", "-");
        System.out.println(str);

//        System.out.println(str.contains("."));
    }


}

