package com.nagare.throwable;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ExHandler<E extends Exception> {

    Optional<E> get(); // TODO

    default void ifCatch(Consumer<E> handler) {
        Objects.requireNonNull(handler);
        get().ifPresent(handler);
    }
}
