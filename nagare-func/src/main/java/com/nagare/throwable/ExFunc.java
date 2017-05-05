package com.nagare.throwable;

import java.util.Optional;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ExFunc<X, A> {
    Optional<A> apply(X x);

    /**
     * {@link #apply(Object)}
     */
    default Optional<A> by(X x) {
        return apply(x);
    }
}
