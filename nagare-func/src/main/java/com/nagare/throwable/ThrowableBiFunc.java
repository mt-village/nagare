package com.nagare.throwable;

import java.util.Optional;

@FunctionalInterface
public interface ThrowableBiFunc<X, Y, A, E extends Exception> {
    A apply(X x, Y y) throws E;

    default ExBiFunc<X, Y, A> ifCatch(ExHandler<E> handler) {
        return (X x, Y y) -> {
            try {
                return Optional.of(apply(x, y));
            } catch (Exception e) {
                @SuppressWarnings("unchecked")
                E typedE = (E) e; // is type safe
                handler.handle(typedE);
            }
            return Optional.empty();
        };
    }
}
