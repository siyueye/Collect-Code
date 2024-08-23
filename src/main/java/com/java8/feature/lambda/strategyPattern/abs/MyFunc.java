package com.java8.feature.lambda.strategyPattern.abs;

@FunctionalInterface
public interface MyFunc<T> {
    public T getValue(T t);
}
