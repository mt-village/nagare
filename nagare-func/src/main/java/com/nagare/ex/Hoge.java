package com.nagare.ex;

import java.io.IOException;
import java.util.Optional;

import org.junit.Test;

import com.nagare.Do;

/**
 * @author ken.murayama
 *
 */
public class Hoge {

    @Test
    public void test3() {
        Do.when("test9.csv").doneTry(this::raiseConIOException)
                .handleEx(System.out::println);
    }

    private void raiseConIOException(String s) throws IOException {
        throw new IOException("this is test ex for input :".concat(s));
    }

    private Integer raiseFuncIOException(String s) throws IOException {
        if (s.equals("yama")) {
            return 1;
        }
        throw new IOException("this is test ex for input :".concat(s));
    }

    @Test
    public void test7() {
        Optional<Integer> i = Do.when("yama")
                .thenTry(this::raiseFuncIOException)
                .handler(System.out::println);
        i.ifPresent(System.out::println);
    }

    @Test
    public void test9() {
        Do.when("yama").thenTry(this::raiseFuncIOException)
                .handler(System.out::println).ifPresent(System.out::println);
    }

    @Test
    public void test8() {
        try {
            Integer i = raiseFuncIOException("yama");
            System.out.println(i);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @Test
    public void test4() {
        Integer.valueOf("sy");
    }
}
