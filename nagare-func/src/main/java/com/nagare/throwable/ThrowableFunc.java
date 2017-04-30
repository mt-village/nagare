package com.nagare.throwable;

import java.util.Optional;

import com.nagare.base.Func;
import com.nagare.base.Spender;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ThrowableFunc<X, A, E extends Exception> {
    A apply(X t) throws E;

    default Func<X, Optional<A>> doIfCatch(Spender<E> handler) {
        return x -> {
            try {
                return Optional.of(apply(x));
            } catch (Exception e) {
                @SuppressWarnings("unchecked")
              E typedE = (E) e; // is type safe
              handler.accept(typedE);
            }
            return Optional.empty();
        };
    }
}
