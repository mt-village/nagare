package com.nagare.ex;

/**
 * @author ken.murayama
 *
 */
public interface ThrowableConsumer<T, E extends Exception> {
    void accept(T t) throws E;
}
