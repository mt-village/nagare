package com.nagare.tertiary;

/**
 * @author ken.murayama
 *
 */
public class If {
    public static BoolSaver isTrue(Boolean b) {
        return () -> b;
    }
}
