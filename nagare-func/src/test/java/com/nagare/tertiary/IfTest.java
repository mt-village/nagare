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
    }

}
