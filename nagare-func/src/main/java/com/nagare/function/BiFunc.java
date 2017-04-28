package com.nagare.function;

import java.util.Objects;
import java.util.function.BiFunction;

/**
 * @author ken.murayama
 * @see BiFunction
 *
 */
@FunctionalInterface
public interface BiFunc<X, Y, A> {

    A apply(X x, Y y);

    /**
     * {@link #apply(Object, Object)}
     */
    default A by(X x, Y y) {
        return apply(x, y);
    }

    default <B> BiFunc<X, Y, B> then(Func<? super A, ? extends B> after) {
        Objects.requireNonNull(after);
        return (X x, Y y) -> after.apply(apply(x, y));
    }

    default BiFunction<X, Y, A> origin() {
        return (X x, Y y) -> apply(x, y);
    }
}
