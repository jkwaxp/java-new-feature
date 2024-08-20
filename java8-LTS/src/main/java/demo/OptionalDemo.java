package demo;


import bean.Person;

import java.util.Optional;

/**
 * Optional示例
 */
public class OptionalDemo {

    public static void main(String[] args) {
        empty();
        notEmpty();
    }

    private static void empty(){
        Optional<String> str = Optional.empty();
        //有值时返回true，否则返回false
        System.out.println("isPresent: " + str.isPresent());
        //有值时返回值，否则返回orElse的值
        System.out.println("orElse: " + str.orElse("empty"));
        //有值时返回值，否则返回orElse提供的值
        System.out.println("orElseGet: " + str.orElseGet(() -> "supplier"));
    }

    private static void notEmpty(){
        Optional<String> str = Optional.of("hello");
        //返回值
        System.out.println("get: " + str.get());
        //有值时返回值，否则抛出异常
        System.out.println("orElseThrow: " + str.orElseThrow(() -> new NullPointerException()));
        //有值时执行filter的Predicate
        System.out.println("filter: " + str.filter(s -> s.startsWith("h")).isPresent());
        //有值时执行map内的Function(返回值类型与原类型一直)
        System.out.println("map: " + str.map(s -> s + " world").get());
        //有值时执行map内的Function(返回值为Optional<Object>类型)，
        System.out.println("flatMap: " + str.flatMap(s -> Optional.of(new Person(s))).get());
    }
}
