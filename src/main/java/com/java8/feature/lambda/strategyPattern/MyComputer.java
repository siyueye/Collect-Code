package com.java8.feature.lambda.strategyPattern;

import com.java8.feature.lambda.strategyPattern.abs.MyComp;

public class MyComputer {
    public void operate(Long num1, Long num2, MyComp<Long, Long> myComp){
        System.out.println(myComp.getValue(num1, num2));
    }

}
