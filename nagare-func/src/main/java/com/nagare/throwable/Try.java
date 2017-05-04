package com.nagare.throwable;

/**
 * @author ken.murayama
 *
 */
public class Try {
    public static <X, A, E extends Exception> ThrowableFunc<X, A, E> throwable(
            ThrowableFunc<X, A, E> f) { //test
        return f;
    }

    public static <A> ExSaver<A> when(A a) {
        return () -> a;
    }
}
