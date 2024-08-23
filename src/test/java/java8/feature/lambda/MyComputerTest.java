package java8.feature.lambda;

import com.java8.feature.lambda.strategyPattern.MyComputer;
import org.junit.Test;

import java.util.function.BiFunction;

public class MyComputerTest<T, U, R> {
    MyComputer myComputer = new MyComputer();
    public R compare(BiFunction biFunction,T t, U u){
        System.out.println(biFunction.apply(t,u));

        return (R) biFunction.apply(t,u);
    }
    @Test
    public void test1() {
        myComputer.operate(100L, 200L, (x, y) -> x + y);
    }
    @Test
    public void test2(){
        myComputer.operate(100L, 200L, (x, y) -> x * y);
    }
    @Test
    public void test3(){
        compare((BiFunction) (x, y) -> x.equals(y), (T) "binghe", (U) "binghe");
    }

}
