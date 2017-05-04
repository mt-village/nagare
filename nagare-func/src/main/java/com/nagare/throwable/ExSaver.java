package com.nagare.throwable;

import java.util.Objects;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ExSaver<A> {
    A get();

    default <E extends Exception> ExSpender<A, E> ifCatch(
            ExHandler<E> handler) {
        Objects.requireNonNull(handler);
        return s -> {
            try {
                s.accept(get());
            } catch (Exception e) {
                @SuppressWarnings("unchecked")
                E typedE = (E) e; // is type safe
                handler.handle(typedE);
            }
        };
    }
}
