package com.nagare.tertiary;

import java.util.function.Predicate;

import org.junit.Test;

public class IfTest {

    @Test
    public void test() {
        Predicate<String> testee = s -> s.length() == 4;
        String s = If.correct(testee.test("piy"))
                .then("is true")
                .orElse("is false");
        System.out.println(s);

        int[] a = {1,2};
        int i = 3;
        System.out.println("i = " + i);
        System.out.println("length = " + a.length);
        int result = If.correct(i < a.length).then(() ->a[i]).orElse(() ->-1).get();
        System.out.println(result);
        result = If.correct(i > a.length)
                .then(() -> -1)
                .orElse(() -> a[i])
                .get();
        System.out.println(result);
    }

}
