package com.nagare.function;

import java.util.Objects;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * @author ken.murayama
 *
 */
@FunctionalInterface
public interface PairSaver<L, R> {

    Pair<L, R> get();

    default <A> PairSaver<A, R> then(Func<? super L, ? extends A> f) {
        Objects.requireNonNull(f);
        Pair<L, R> p = get();
        return () -> ImmutablePair.of(f.apply(p.getLeft()), p.getRight());
    }

    default <A> PairSaver<L, A> thenR(Func<? super R, ? extends A> f) {
        Objects.requireNonNull(f);
        Pair<L, R> p = get();
        return () -> ImmutablePair.of(p.getLeft(), f.apply(p.getRight()));
    }

    default <A> Saver<A> then(BiFunc<? super L, ? super R, ? extends A> bf) {
        Objects.requireNonNull(bf);
        Pair<L, R> p = get();
        return () -> bf.apply(p.getLeft(), p.getRight());
    }

    default <L2, R2> PairSaver<L2, R2> then(PairFunc <? super L, ? super R, L2, R2> pf) {
        Objects.requireNonNull(pf);
        Pair<L, R> p = get();
        return () -> pf.apply(p.getLeft(), p.getRight());
    }

    default void done(BiSpender<? super L, ? super R> bs) {
        Pair<L, R> p = get();
        bs.accept(p.getLeft(), p.getRight());
    }
}
