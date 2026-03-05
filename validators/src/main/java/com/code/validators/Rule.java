package com.code.validators;

@FunctionalInterface
public interface Rule<T> {

    boolean apply(T t);

    default Rule<T> and(Rule<T> other) {
        return t -> this.apply(t) && other.apply(t);
    }
}