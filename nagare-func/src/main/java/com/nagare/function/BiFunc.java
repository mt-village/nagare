package com.nagare.function;

import java.util.Objects;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface BiFunc<T, U, R> {

    R apply(T t, U u);

    /**
     * {@link #apply(Object, Object)}
     */
    default R by(T t, U u) {
        return apply(t, u);
    }

    default <V> BiFunc<T, U, V> then(Func<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> after.apply(apply(t, u));
    }

    default Func<U, R> curry(T t) {
        return (U u) -> apply(t, u);
    }

    default Func<T, R> curryRight(U u) {
        return (T t) -> apply(t, u);
    }
}
