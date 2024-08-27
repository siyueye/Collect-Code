package com.java8.feature.streamFeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream映射的map与flatMap的区别
 * map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
 * flatMap:接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
 */
public class FlatMapAndMap {
    public Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        FlatMapAndMap s = new FlatMapAndMap();
        list.stream().flatMap((e) -> s.filterCharacter(e)).forEach(System.out::println);
        //如果使用map则需要这样写
        list.stream().map((e) -> s.filterCharacter(e)).forEach((e) -> {
            e.forEach(System.out::println);
        });
    }
}
