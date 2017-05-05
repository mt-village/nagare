package com.nagare.throwable;

import java.util.Optional;

@FunctionalInterface
public interface ExBiFunc<X, Y, A> {
    Optional<A> apply(X x, Y y);

    /**
     * {@link #apply(Object, Object)}
     */
    default Optional<A> by(X x, Y y) {
        return apply(x, y);
    }
}
