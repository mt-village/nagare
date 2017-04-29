package com.nagare.ex;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

import org.apache.commons.lang3.tuple.Pair;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ExPairSaver<E extends Exception, A> {
    Pair<Optional<E>, A> get();

    default Optional<A> handleEx(Consumer<E> handle) {
        Objects.requireNonNull(handle);
        if (get().getLeft().isPresent()) {
            handle.accept(get().getLeft().get());
            return Optional.empty();
        }
        return Optional.of(get().getRight());
    }
}
