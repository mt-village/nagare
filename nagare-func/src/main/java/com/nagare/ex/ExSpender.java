package com.nagare.ex;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ExSpender<T, E extends Exception> {
    void accept(T t) throws E;
}
