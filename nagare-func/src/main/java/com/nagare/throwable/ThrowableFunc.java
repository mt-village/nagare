package com.nagare.throwable;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ThrowableFunc<X, A, E extends Exception> {
    A apply(X t) throws E;
}
