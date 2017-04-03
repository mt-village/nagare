package com.nagare.function;

import java.util.Objects;
import java.util.function.Supplier;

@FunctionalInterface
public interface Spender<T> {

    void accept(T t);

    /**
     * {@link #accept(Object)}
     */
    default void by(T t) {
        accept(t);
    }

    default <U> BiSpender<T, U> and(Spender<? super U> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> {
            accept(t);
            after.accept(u);
        };
    }

    default Spender<T> then(Spender<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> {
            accept(t);
            after.accept(t);
        };
    }

    default <R> Func<T, R> then(Supplier<R> after) {
        Objects.requireNonNull(after);
        return (T t) -> {
            accept(t);
            return after.get();
        };
    }
}
