package com.nagare.tertiary;

import java.util.function.Supplier;

@FunctionalInterface
public interface ElseSaver<A> {
    Supplier<A> orElse(Supplier<A> a2);
}
