package com.nagare.throwable;

import java.util.Optional;

import com.nagare.base.Spender;

/**
 * @author ken.murayama
 *
 */
public interface ExResolveFunc<A, E extends Exception> {
    Optional<A> ifCatch(Spender<E> handler);
}
