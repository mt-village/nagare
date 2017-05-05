package com.nagare.throwable;

import com.nagare.base.Spender;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ThrowableSpender<X, E extends Exception> {
    void accept(X x) throws E;

    default Spender<X> ifCatch(ExHandler<E> handler) {
        return (X x) -> {
            try {
                accept(x);
            } catch (Exception e) {
                @SuppressWarnings("unchecked")
                E typedE = (E) e; // is type safe
                handler.handle(typedE);
            }
        };
    }
}
