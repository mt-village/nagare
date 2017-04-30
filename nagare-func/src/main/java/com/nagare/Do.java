package com.nagare;

import org.apache.commons.lang3.tuple.ImmutablePair;

import com.nagare.function.BiFunc;
import com.nagare.function.Func;
import com.nagare.function.PairSaver;
import com.nagare.function.Saver;

/**
 * @author ken.murayama
 *
 */
public class Do {
    public static <X, A> Func<X, A> first(Func<X, A> f) {
        return f;
    }

    public static <X, Y, A> BiFunc<X, Y, A> first(BiFunc<X, Y, A> f) {
        return f;
    }

    public static <A> Saver<A> when(A a) {
        return () -> a;
    }

    public static <L, R> PairSaver<L, R> when(L l, R r) {
        return () -> ImmutablePair.of(l, r);
    }
}
