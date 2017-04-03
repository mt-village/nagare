package com.nagare;

import com.nagare.function.BiFunc;
import com.nagare.function.BiSpender;
import com.nagare.function.Func;
import com.nagare.function.Spender;

public class Do {
    public static <T, R> Func<T, R>  first(Func<T, R> f) {
        return f;
    }

    public static <T, U, R> BiFunc<T, U, R>  first(BiFunc<T, U, R> f) {
        return f;
    }

    public static <T> Spender<T>  first(Spender<T> f) {
        return f;
    }

    public static <T, U> BiSpender<T, U>  first(BiSpender<T, U> f) {
        return f;
    }
}
