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

    Optional<E> get();

    default void ifCatch(Consumer<E> handle) {
        Objects.requireNonNull(handle);
        get().ifPresent(handle);
    }
}
