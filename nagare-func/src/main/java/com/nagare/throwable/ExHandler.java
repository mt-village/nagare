package com.nagare.throwable;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ExHandler<E extends Exception> {
    void handle(E e);
}
