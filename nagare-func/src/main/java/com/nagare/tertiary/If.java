package com.nagare.tertiary;

/**
 * @author ken.murayama
 *
 */
public class If {
    public static BoolSaver correct(Boolean b) {
        return () -> b;
    }
}
