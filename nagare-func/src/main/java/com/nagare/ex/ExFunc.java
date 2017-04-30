package com.nagare.ex;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ExFunc<X, A, E extends Exception> {
    A apply(X t) throws E;
}
