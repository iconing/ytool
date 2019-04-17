package lambda;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class LambdaTest {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("sss");
            }
        };

        Stream<String> s = Stream.of("a1", "a2", "a3", "b1");
        s.filter(t -> {
            System.out.println("aaa");
            return true;
        }).count();

        System.out.println("2222");

        String a = "11";
        Runnable r2 = () -> System.out.println(a);
    }

    @Test
    public void testVar() {
        Integer[] ins = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(ins).mapToInt(t -> t).sum();
    }
}
