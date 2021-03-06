package com.nagare.throwable;

import java.util.Optional;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ThrowableFunc<X, A, E extends Exception> {
    A apply(X x) throws E;

    default ExFunc<X, A> ifCatch(ExHandler<E> handler) {
        return x -> {
            try {
                return Optional.of(apply(x));
            } catch (Exception e) {
                @SuppressWarnings("unchecked")
                E typedE = (E) e; // is type safe
                handler.handle(typedE);
            }
            return Optional.empty();
        };
    }
}
