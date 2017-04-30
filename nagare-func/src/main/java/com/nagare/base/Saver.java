package com.nagare.base;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import com.nagare.ex.ExResolveFunc;
import com.nagare.ex.ExResolver;
import com.nagare.ex.ExSpender;
import com.nagare.ex.ExFunc;

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

    default <E extends Exception> ExResolver<E> doneTry(
            ExSpender<? super A, E> c) {
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

    default <B, E extends Exception> ExResolveFunc<E, B> thenTry(
            ExFunc<? super A, B, E> f) {
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
