package com.nagare.ex;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ExSaver<E extends Exception> {
    Optional<E> get();

    default void handleEx(Consumer<E> handle) {
        Objects.requireNonNull(handle);
        get().ifPresent(handle);
    }
}
