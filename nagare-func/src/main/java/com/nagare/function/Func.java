package com.nagare.function;

import java.util.Objects;

import org.apache.commons.lang3.tuple.ImmutablePair;

@FunctionalInterface
public interface Func<T, R> {

    R apply(T t);

    /**
     * {@link #apply(Object)}
     */
    default R by(T t) {
        return apply(t);
    }

    default <V, W> PairFunc<T, V, R, W> and(Func<? super V, ? extends W> f) {
        Objects.requireNonNull(f);
        return (T t, V v) -> ImmutablePair.of(apply(t), f.apply(v));
    }

    default <V, W> BiFunc<T, V, W> then(BiFunc<? super R, ? super V, ? extends W> after) {
        Objects.requireNonNull(after);
        return (T t, V v) -> after.apply(apply(t), v);
    }

    default <V> Func<T, V> then(Func<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    default Spender<T> then(Spender<? super R> after) {
        return (T t) -> after.accept(apply(t));
    }

    default <V> BiSpender<T, V> then(BiSpender<? super R, ? super V> after) {
        return (T t, V v) -> after.accept(apply(t), v);
    }
}
