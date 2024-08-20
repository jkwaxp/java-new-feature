package demo;

import bean.Person;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * 函数式接口
 */
public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        supplier();
        consumer();
        function();
        predicate();

        demo();
    }

    //Supplier：供给型接口 表示一个函数 无入参，有返回值
    private static void supplier(){
        Supplier<String> demo = () -> "supplier";
        System.out.println(demo.get());
    }

    //Consumer：消费接口 表示一个函数 有入参，无返回值
    private static void consumer() {
        Consumer<String> print = t -> System.out.println(t);
        print.accept("consumer");

        //andThen: 先执行自己的accept,再执行andThen的accept
        print.andThen(print).accept("consumer");


        //BiConsumer 两个参数的consumer
        BiConsumer<String, String> mergePrint = (t, u) -> System.out.println(t + u);
        mergePrint.accept("helo", "world");

        //andThen: 先执行自己的accept,再执行andThen的accept
        mergePrint.andThen(mergePrint).accept("helo", "world");
    }

    //Function： 表示一个函数 需要一个参数，有返回值
    private static void function(){
        Function<Integer, Integer> plus = (i) ->  i + 1;
        //调用函数
        System.out.println(plus.apply(1));

        Function<Integer, Integer> multiply = (i) -> i *2;
        //组合两个函数，compose函数先执行
        System.out.println(plus.compose(multiply).apply(1));
        //组合两个函数，andThen函数后执行
        System.out.println(plus.andThen(multiply).apply(1));

        //identity 总是返回输入参数
        Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(1));


        //BiFunction： 表示一个函数 需要两个参数
        BiFunction<String, String, String> mergeStr = (left, right) -> left + right;
        //调用函数
        System.out.println(mergeStr.apply("hello ", "world"));

        //组合一个Function, andThen函数后执行， biFunction的返回值是andThen函数的入参
        Function<String, String> suffix = str -> str + "!";
        System.out.println(mergeStr.andThen(suffix).apply("hello ", "world"));
    }

    //Predicate: 断言型接口 有入参，返回值为布尔型
    private static void predicate() {
        //是否为正数
        Predicate<Integer> isPositive = i -> i > 0;
        //是否为偶数
        Predicate<Integer> isEven = i -> i % 2 == 0;

        System.out.println(isPositive.test(10));
        System.out.println(isPositive.test(-10));

        //negate 非运算
        System.out.println(isPositive.negate().test(10));
        System.out.println(isPositive.negate().test(-10));

        //and  && 运算
        System.out.println(isPositive.and(isEven).test(10));
        System.out.println(isPositive.and(isEven).test(11));

        //or  || 运算
        System.out.println(isPositive.or(isEven).test(10));
        System.out.println(isPositive.or(isEven).test(-10));
    }

    private static void demo(){
        //supplier
        Supplier<Person> supplier = Person::new;
        System.out.println(supplier.get().getName());

        //consumer
        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(System.out::println);
        list.forEach(str -> System.out.println(str));

        //biConsumer
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.forEach((k, v) -> System.out.println(k + ":" + v));

        //function
        List<Integer> nums = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = nums.stream().map(num -> num + 1).collect(Collectors.toList());
        System.out.println(nums2);
    }

}
