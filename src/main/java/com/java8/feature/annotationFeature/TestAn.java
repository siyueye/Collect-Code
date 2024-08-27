package com.java8.feature.annotationFeature;


@TestAnnotation
public class TestAn {

    public static void main(String[] args) {
        boolean hasAnnotation = TestAn.class.isAnnotationPresent(TestAnnotation.class);
        if (hasAnnotation) {
            TestAnnotation testAnnotation = TestAn.class.getAnnotation(TestAnnotation.class);
            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.msg());
        }
    }
}
