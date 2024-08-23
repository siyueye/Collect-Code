package java8.feature.lambda;

import com.java8.feature.lambda.strategyPattern.MyOperaterString;
import org.junit.Test;

import java.util.function.BinaryOperator;

public class MyOperaterStringTest {
    MyOperaterString myopt = new MyOperaterString();

    @Test
    public void test1(){
        String str = myopt.handlerString((s) -> s.toUpperCase(), "binghe");
        System.out.println(str);
    }
    @Test
    public void test2() {
        String str = myopt.handlerString((s) -> s.substring(0, 4), "binghe");
        System.out.println(str);
    }



}
