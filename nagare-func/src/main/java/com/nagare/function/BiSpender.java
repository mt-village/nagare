package com.nagare.function;

import java.util.Objects;
import java.util.function.Consumer;

@FunctionalInterface
public interface BiSpender<T, U> {

    void accept(T t, U u);

    /**
     * {@link #accept(Object, Object)}
     */
    default void by(T t, U u) {
        accept(t, u);
    }

    default BiSpender<T, U> then(BiSpender<? super T, ? super U> after) {
        Objects.requireNonNull(after);
        return (l, r) -> {
            accept(l, r);
            after.accept(l, r);
        };
    }

    default BiSpender<T, U> then(Spender<? super T> after) {
        Objects.requireNonNull(after);
        return (l, r) -> {
            accept(l, r);
            after.accept(l);
        };
    }

    default BiSpender<T, U> then(Consumer<? super U> after) {
        Objects.requireNonNull(after);
        return (l, r) -> {
            accept(l, r);
            after.accept(r);
        };
    }
}