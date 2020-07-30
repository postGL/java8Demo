package com.zbs;

import java.util.function.Function;

/**
 * description: FunctionTest2
 * date: 2020/7/30 14:22
 * author: zhangbs
 * version: 1.0
 */
public class FunctionTest2 {
    public int composeTest(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        System.out.println(a);
        int b = function1.compose(function2).apply(a);
        System.out.println(a);
        return b;
    }

    public static void main(String[] args) {
        FunctionTest2 functionTest2 = new FunctionTest2();
        System.out.println(functionTest2.composeTest(2, value -> value * 3, value -> value * value));
    }
}

