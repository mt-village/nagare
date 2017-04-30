package com.nagare.throwable;

import com.nagare.base.Saver;

public class Try {
    public static <X, A, E extends Exception> ThrowableFunc<X, A, E> throwable(
            ThrowableFunc<X, A, E> f) {
        return f;
    }

    public static <A> Saver<A> when(A a) {
        return () -> a;
    }
}
