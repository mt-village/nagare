package com.nagare.tertiary;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface BoolSaver {
    Boolean get();

    default <A> Else<A> then(A a1) {
        return (A a2) -> get() ? a1 : a2;
    }
}
