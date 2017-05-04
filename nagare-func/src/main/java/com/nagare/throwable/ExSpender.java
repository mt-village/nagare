package com.nagare.throwable;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ExSpender<A, E extends Exception> {
    void done(ThrowableSpender<? super A, E> s);
}
