package com.nagare.throwable;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface Hoge<A, E extends Exception> {
    void done(ThrowableSpender<? super A, E> s);
}
