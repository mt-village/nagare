package com.nagare.function;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author ken.murayama
 * @see Consumer
 *
 */
@FunctionalInterface
public interface Spender<X> {

    void accept(X x);

    /**
     * {@link #accept(Object)}
     */
    default void by(X x) {
        accept(x);
    }

    default <Y> BiSpender<X, Y> and(Spender<? super Y> after) {
        Objects.requireNonNull(after);
        return (X x, Y y) -> {
            accept(x);
            after.accept(y);
        };
    }

    default Spender<X> then(Spender<? super X> after) {
        Objects.requireNonNull(after);
        return (X x) -> {
            accept(x);
            after.accept(x);
        };
    }

    default Consumer<X> origin() {
        return (X x) -> accept(x);
    }
}
