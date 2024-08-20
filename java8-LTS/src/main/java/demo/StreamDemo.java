package demo;

import bean.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream相关示例
 */
public class StreamDemo {

    public static void main(String[] args) {
        filter();
        map();
        flatMap();
        sort();
        match();
        reduce();
        collect();
    }

    //过滤元素
    private static void filter(){
        //filter: 传入一个Predicate, 结果为true的元素组成新的stream返回
        //peek: 流中的每个元素都执行一次传入的consumer函数
        List<Integer> result = Stream.of(1, 2, 3, 4, 5)
                .filter(i -> i > 3)
                .peek(i -> System.out.println("filtered value: " + i))
                .collect(Collectors.toList());
        System.out.println("filter: " + result);

        //limit: 截断流
        System.out.println(Stream.of(1, 2, 3, 4, 5)
                .limit(3).collect(Collectors.toList()));

        //skip： 跳过前几个元素
        System.out.println(Stream.of(1, 2, 3, 4, 5)
                .skip(4).collect(Collectors.toList()));
    }

    //将流中的每个元素映射到另一个元素，返回一个新的流，流中的元素数量与原始流相同
    private static void map(){
        System.out.println(Stream.of("John", "Alex", "Jerry", "Kevin")
                .map(name -> name.startsWith("J"))
                .collect(Collectors.toList()));

        System.out.println(Stream.of("John", "Alex", "Jerry", "Kevin")
                .map(String::length)
                .collect(Collectors.toList()));

        System.out.println(Stream.of("John", "Alex", "Jerry", "Kevin")
                .mapToInt(String::length)
                .mapToObj(i -> i + 1)
                .collect(Collectors.toList()));

        System.out.println(Stream.of("John", "Alex", "Jerry", "Kevin")
                .mapToInt(String::length)
                .max().getAsInt());
    }

    //将流中的每个元素映射到一个流，并将所有流合并成一个流。返回一个新的流，流中的元素数量可能与原始流不同
    private static void flatMap(){
        System.out.println(Stream.of("John Wick", "Alex Newton", "Jerry Lin", "Kevin Bosh")
                .flatMap(name -> Arrays.asList(name.split(" ")).stream())
                .collect(Collectors.toList()));

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Alice", "Bob"),
                Arrays.asList("Charlie", "David")
        );
        System.out.println(listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList()));

        System.out.println(listOfLists.stream()
                .flatMapToInt(list -> list.stream().mapToInt(String::length))
                .mapToObj(i -> i)
                .collect(Collectors.toList()));
    }

    private static void sort(){
        System.out.println(Stream.of(4, 3, 5, 3, 1)
                .sorted().collect(Collectors.toList()));
        System.out.println(Stream.of("John", "Alex", "Jerry", "Kevin")
                .sorted().collect(Collectors.toList()));

        List<Person> men = Arrays.asList(new Person("John", 18),
                new Person("Alex", 25),
                new Person("Jerry", 24),
                new Person("Kevin", 16));
        System.out.println(men.stream()
                .sorted((left, right) -> left.getAge() > right.getAge() ? 1 : -1).collect(Collectors.toList()));
    }

    private static void match(){
        List<String> names = Arrays.asList("John", "Alex", "Jerry", "Kevin");
        System.out.println(names.stream()
                .anyMatch(name -> name.endsWith("x")));

        System.out.println(names.stream()
                .allMatch(name -> name.endsWith("x")));

        System.out.println(names.stream()
                .noneMatch(name -> name.endsWith("a")));

        System.out.println("findFirst: " + names.stream().findFirst().get());
        for (int i = 0; i < 10; i++) {
            System.out.println("findAny: " + names.stream().parallel().findAny().get());
        }
    }

    //对流中的元素进行聚合操作
    private static void reduce(){
        //未指定初始值
        System.out.println(Stream.of("hello", " ", "world", "!")
                .reduce((a, b) -> a + b).get());

        //指定初始值
        System.out.println(Stream.of(1, 2, 3, 4, 5)
                .reduce(0, (a, b) -> a + b));
        System.out.println(Stream.of(1, 2, 3, 4, 5)
                .reduce(10, (a, b) -> a + b));
        //并行时，每个线程初始值都增加identity
        System.out.println(Stream.of(1, 2, 3, 4, 5).parallel()
                .reduce(10, (a, b) -> a + b));

        //combiner合并多线程计算的结果
        System.out.println(Stream.of(1, 2, 3, 4, 5).parallel()
                .reduce(0, (a, b) -> a + b, (a, b) -> a * b).intValue());
    }

    private static void collect(){
        //转成ArrayList
        System.out.println(Stream.of("a", "b", "c").collect(Collectors.toList()));
        //转成HashSet
        System.out.println(Stream.of("a", "b", "a").collect(Collectors.toSet()));
        //统计元素个数
        System.out.println(Stream.of("a", "b", "c").collect(Collectors.counting()));

        List<Person> list = Arrays.asList(new Person("John", 16),
                new Person("Alex", 20),
                new Person("Jerry", 20));
        //转成map
        Map<String, Person> map = list.stream().collect(Collectors.toMap(person -> person.getName(), person -> person));
        System.out.println(map);
        //分组后转map
        Map<Integer, List<Person>> groupedMap = list.stream().collect(Collectors.groupingBy(person -> person.getAge(), Collectors.toList()));
        System.out.println(groupedMap);

        //执行过程类似reduce
        System.out.println(Stream.of("hello", " ", "world", "!")
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString());
    }
}
