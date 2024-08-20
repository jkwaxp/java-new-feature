package demo;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * lambada基本用法
 * (paramaters) -> expression
 * () -> {statement;}
 */
public class LambadaDemo {

    public static void main(String[] args) {
        //无参写法
        Runnable l1 = () -> System.out.println("xxx");

        //一个参数
        Consumer<String> l2 = s -> System.out.println(s);

        //多个参数
        BiConsumer<String, String> l3 = (a, b) -> System.out.println(a + b);

        //有返回值
        Function<Integer, Integer> l4 = i -> {return i + 1;};
    }
}
