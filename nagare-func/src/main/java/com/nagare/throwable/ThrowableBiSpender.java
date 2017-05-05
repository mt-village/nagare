package com.nagare.throwable;

import com.nagare.base.BiSpender;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ThrowableBiSpender<X, Y, E extends Exception> {
    void accept(X x, Y y) throws E;

    default BiSpender<X, Y> ifCatch(ExHandler<E> handler) {
        return (X x, Y y) -> {
            try {
                accept(x, y);
            } catch (Exception e) {
                @SuppressWarnings("unchecked")
                E typedE = (E) e; // is type safe
                handler.handle(typedE);
            }
        };
    }
}
