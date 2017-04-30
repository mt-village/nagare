package com.nagare.throwable;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author ken.murayama
 *
 */
public interface ExResolveFunc<E extends Exception, A> {
    Optional<A> ifCatch(Consumer<E> s);
}
