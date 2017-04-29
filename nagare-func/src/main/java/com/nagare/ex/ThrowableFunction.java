package com.nagare.ex;

/**
 * @author ken.murayama
 *
 */
public interface ThrowableFunction<X, A, E extends Exception> {
    A apply(X t) throws E;
}
