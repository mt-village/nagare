package com.nagare.throwable;

import java.io.IOException;
import java.util.Optional;

import org.junit.Test;

public class ThrowableExamples {

    @Test
    public void usually_try_style() {
        try {
            Integer i = raiseEx2("nagare");
            System.out.println(i);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Test
    public void test1() {
        Optional<Integer> i = Try.throwable(this::raiseEx2)
                .ifCatch(System.out::println)
                .by("nagare");
        i.ifPresent(System.out::println);
    }

    @Test
    public void test3() {
        Try.when("nagare").ifCatch(System.out::println)
                .done(this::raiseEx1);
    }

    private void raiseEx1(String s) throws IOException {
        if (s.equals("nagare")) {
            System.out.println("0");
        }
        throw new IOException("this is test ex for input :".concat(s));
    }

    private Integer raiseEx2(String s) throws IOException {
        if (s.equals("nagare")) {
            return 0;
        }
        throw new IOException("this is test ex for input :".concat(s));
    }
}
