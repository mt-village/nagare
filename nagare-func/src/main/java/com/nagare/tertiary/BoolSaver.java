package com.nagare.tertiary;

import java.util.function.Supplier;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface BoolSaver {
    Boolean get();

    default <A> Else<A> then(A a1) {
        return (A a2) -> get() ?  a1 : a2;
    }

    default <A> ElseSaver<A> then(Supplier<A> a1) {
        return (Supplier<A> a2) -> get() ? a1 : a2;
    }
}
