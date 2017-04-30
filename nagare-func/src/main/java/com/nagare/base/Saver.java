package com.nagare.base;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.nagare.throwable.Hoge;

/**
 * @author ken.murayama
 * @see Supplier
 *
 */
@FunctionalInterface
public interface Saver<A> {

    A get();

    /**
     * {@link #get()}
     */
    default A let() {
        return get();
    }

    default <B> Saver<B> then(Func<? super A, ? extends B> f) {
        Objects.requireNonNull(f);
        return () -> f.apply(get());
    }

    default void done(Spender<? super A> s) {
        s.accept(get());
    }

    default <E extends Exception> Hoge<A, E> ifCatch(
            Consumer<E> handler) {
        Objects.requireNonNull(handler);
        return s -> {
            try {
                s.accept(get());
            } catch (Exception e) {
                @SuppressWarnings("unchecked")
                E typedE = (E) e; // is type safe
                handler.accept(typedE);
            }
        };
    }

    default Supplier<A> origin() {
        return () -> get();
    }
}
