package com.nagare.function;

import java.util.Objects;

import org.apache.commons.lang3.tuple.Pair;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface PairFunc <X, Y, L, R> {

    Pair<L, R> apply(X x, Y y);

    default <A> BiFunc<X, Y, A> then(BiFunc<? super L, ? super R, ? extends A> after) {
        Objects.requireNonNull(after);
        return (X x, Y y) -> {
            Pair<L, R> p = apply(x, y);
            return after.apply(p.getLeft(), p.getRight());
        };
    }
}
