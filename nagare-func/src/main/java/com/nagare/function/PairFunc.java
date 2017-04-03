package com.nagare.function;

import java.util.Objects;

import org.apache.commons.lang3.tuple.Pair;

@FunctionalInterface
public interface PairFunc <T, U, L, R> {

    Pair<L, R> apply(T t, U u);

    default <W> BiFunc<T, U, W> then(BiFunc<? super L, ? super R, ? extends W> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> {
            Pair<L, R> pair = apply(t, u);
            return after.apply(pair.getLeft(), pair.getRight());
        };
    }
}
