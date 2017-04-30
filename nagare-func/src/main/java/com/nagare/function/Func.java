package com.nagare.function;

import java.util.Objects;
import java.util.function.Function;

import org.apache.commons.lang3.tuple.ImmutablePair;

/**
 * @author ken.murayama
 * @see Function
 *
 */
@FunctionalInterface
public interface Func<X, A> {

    A apply(X x);

    /**
     * {@link #apply(Object)}
     */
    default A by(X x) {
        return apply(x);
    }

    default <B> Func<X, B> then(Func<? super A, ? extends B> after) {
        Objects.requireNonNull(after);
        return (X x) -> after.apply(apply(x));
    }

    default <Y, B> PairFunc<X, Y, A, B> and(Func<? super Y, ? extends B> f) {
        Objects.requireNonNull(f);
        return (X x, Y y) -> ImmutablePair.of(apply(x), f.apply(y));
    }

    default <Y, B> BiFunc<X, Y, B> then(
            BiFunc<? super A, ? super Y, ? extends B> after) {
        Objects.requireNonNull(after);
        return (X x, Y y) -> after.apply(apply(x), y);
    }

    default <Y, W> BiFunc<Y, X, W> thenR(
            BiFunc<? super Y, ? super A, ? extends W> after) {
        Objects.requireNonNull(after);
        return (Y y, X x) -> after.apply(y, apply(x));
    }

    default Function<X, A> origin() {
        return (X x) -> apply(x);
    }
}
