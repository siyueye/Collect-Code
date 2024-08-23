package com.java8.feature.lambda.strategyPattern;

import com.java8.feature.lambda.strategyPattern.abs.MyFunc;

public class MyOperaterString  {
    public String handlerString(MyFunc<String> myFunc, String str){
        return myFunc.getValue(str);
    }
}
