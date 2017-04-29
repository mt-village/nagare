package com.nagare.ex;

import java.io.File;
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
        Do.when("test9.csv").tried(this::raiseConIOException).handleEx(this::handle);
    }

    @Test
    public void test5() {
        try {
            new File("test9.csv").getCanonicalFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void handle(IOException e) {
        System.out.println(e.getMessage());
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
    public void test6() {
        Optional<Integer> s = Do.when("test.csv")
                .doTry(this::raiseFuncIOException)
                .handleEx(this::handle);
    }

    @Test
    public void test4() {
        Integer.valueOf("sy");
    }
}
