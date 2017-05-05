package com.nagare.throwable;

/**
 * @author ken.murayama
 *
 */
public class Try {
    public static <X, A, E extends Exception> ThrowableFunc<X, A, E> throwable(
            ThrowableFunc<X, A, E> f) {
        return f;
    }

    public static <X, E extends Exception> ThrowableSpender<X, E> throwable(
            ThrowableSpender<X, E> s) {
        return s;
    }

    public static <X, Y, A, E extends Exception> ThrowableBiFunc<X, Y, A, E> throwable(
            ThrowableBiFunc<X, Y, A, E> f) {
        return f;
    }

    public static <X, Y, E extends Exception> ThrowableBiSpender<X, Y, E> throwable(
            ThrowableBiSpender<X, Y, E> s) {
        return s;
    }
}
