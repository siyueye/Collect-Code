package com.java8.feature.lambda.strategyPattern.abs;

/**
 *
 * @param <T> T作为参数的类型
 * @param <R> R作为返回值的类型
 */
@FunctionalInterface
public interface MyComp <T, R>{
    R getValue(T t1, T t2);

}
