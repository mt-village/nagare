package com.nagare.throwable;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface ExSpender<E extends Exception> {
    void handleEx(E e);
}
