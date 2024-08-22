package java8.feature.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class AnonymousTest {
    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(com);
    }
    @Test
    public void lambdaTest(){
        TreeSet<Integer> treeSet = new TreeSet<>((x, y) -> Integer.compare(x, y));
        TreeSet<Integer> treeSet1 = new TreeSet<>( Integer::compare);
    }

}
