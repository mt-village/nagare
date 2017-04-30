package com.nagare.throwable;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ThrowableSpender<T, E extends Exception> {
    void accept(T t) throws E;
}
