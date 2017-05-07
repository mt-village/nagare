package com.nagare.util;

import java.util.Arrays;
import java.util.Optional;


public class Lookupper {

    public static <E extends Labeled> E lookup(E[] values, String s) {
        return Arrays.stream(values)
                .filter(e -> e.label().equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException
                                (String.format("Unsupported type %s.", s)));
    }

    public static <E extends Labeled> Optional<E> lookupNullable(E[] values, String s) {
        return Arrays.stream(values)
                .filter(e -> e.label().equals(s))
                .findFirst();
    }
}
