package com.nagare.function;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import com.nagare.ex.ExFunc;
import com.nagare.ex.ExSaver;
import com.nagare.ex.ThrowableConsumer;
import com.nagare.ex.ThrowableFunction;

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

    default <E extends Exception> ExSaver<E> doneTry(
            ThrowableConsumer<? super A, E> c) {
        Objects.requireNonNull(c);
        try {
            c.accept(get());
            return () -> Optional.empty();
        } catch (Exception e) {
            @SuppressWarnings("unchecked")
            Optional<E> oe = Optional.of((E) e); // is type safe
            return () -> oe;
        }
    }

    default <B, E extends Exception> ExFunc<E, B> thenTry(
            ThrowableFunction<? super A, B, E> f) {
        Objects.requireNonNull(f);
        try {
            B res = f.apply(get());
            return c -> Optional.of(res);
        } catch (Exception e) {
            @SuppressWarnings("unchecked")
            E ex = (E) e; // is type safe
            return c -> {
                c.accept(ex);
                return Optional.empty();
            };
        }
    }

    default Supplier<A> origin() {
        return () -> get();
    }
}
