package com.nagare.tertiary;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface Else<A> {
    A orElse(A a1);
}
