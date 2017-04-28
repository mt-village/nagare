package com.nagare.function;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import com.nagare.ex.ExSaver;
import com.nagare.ex.ThrowableConsumer;

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

    default <E extends Exception> ExSaver<E> tried(ThrowableConsumer<? super A, E> c) {
        Objects.requireNonNull(c);
            try {
                c.accept(get());
                return () -> Optional.empty();
            } catch (Exception e) {
                @SuppressWarnings("unchecked")
                Optional<E> oe =  Optional.of((E)e); // is type safe
                return () -> oe;
            }
    }

    default Supplier<A> origin() {
        return () -> get();
    }
}
