package com.nagare.ex;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ExResolver<E extends Exception> {
    Optional<E> get();

    default void ifCatch(Consumer<E> handle) {
        Objects.requireNonNull(handle);
        get().ifPresent(handle);
    }
}
