package com.nagare.base;

import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * @author ken.murayama
 * @see BiConsumer
 *
 */
@FunctionalInterface
public interface BiSpender<X, Y> {
    void accept(X x, Y y);

    /**
     * {@link #accept(Object, Object)}
     */
    default void by(X x, Y y) {
        accept(x, y);
    }

    default BiSpender<X, Y> then(BiSpender<? super X, ? super Y> after) {
        Objects.requireNonNull(after);
        return (X x, Y y) -> {
            accept(x, y);
            after.accept(x, y);
        };
    }

    default BiConsumer<X, Y> origin() {
        return (X x, Y y) -> accept(x, y);
    }
}
