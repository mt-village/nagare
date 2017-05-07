package com.nagare.throwable;

import java.io.IOException;
import java.util.Optional;

import org.junit.Test;

/**
 * @author ken.murayama
 *
 */
public class TryExamples {

    @Test
    public void usually_try_style() {
        try {
            raiseIOEx1("nagare");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void nagare_try_style() {
        Try.throwable(this::raiseIOEx1)
                .ifCatch(IOException::printStackTrace)
                .by("nagare");
    }

    @Test
    public void usually_returnable_try_style() {
        try {
            String s = raiseIOEx2("nagare");
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void nagare_returnable_try_style() {
        Optional<String> s = Try.throwable(this::raiseIOEx2)
                .ifCatch(IOException::printStackTrace)
                .by("nagare");
        s.ifPresent(System.out::println);
    }

    @Test
    public void nagare_try_bispender_style() {
        Try.throwable(this::raiseIOEx3)
                .ifCatch(IOException::printStackTrace)
                .by("nagare", "nagare");
    }

    @Test
    public void nagare_returnable_bifunc_try_style() {
        Optional<String> s = Try.throwable(this::raiseIOEx4)
                .ifCatch(IOException::printStackTrace)
                .by("nagare", "nagare");
        s.ifPresent(System.out::println);
    }

    private void raiseIOEx1(String s) throws IOException {
        if (s.equals("nagare")) {
            System.out.println("Excellent!");
            return;
        }
        throw new IOException("this is test ex for input :".concat(s));
    }

    private String raiseIOEx2(String s) throws IOException {
        if (s.equals("nagare")) {
            return "Excellent!";
        }
        throw new IOException("this is test ex for input :".concat(s));
    }

    private void raiseIOEx3(String s1, String s2) throws IOException {
        if (s1.equals("nagare") && s2.equals("nagare")) {
            System.out.println("Excellent!");
            return;
        }
        throw new IOException("this is test ex for input :".concat(s1).concat(" and ").concat(s2));
    }

    private String raiseIOEx4(String s1, String s2) throws IOException {
        if (s1.equals("nagare") && s2.equals("nagare")) {
            return "Excellent!";
        }
        throw new IOException("this is test ex for input :".concat(s1).concat(" and ").concat(s2));
    }
}
