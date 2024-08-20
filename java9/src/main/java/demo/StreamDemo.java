package demo;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        takeWhile();
        dropWhile();
        ofNull();
        iterator();
    }

    private static void takeWhile() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> result = list.stream().takeWhile(i -> i < 4).collect(Collectors.toList());
        System.out.println(result);
    }

    private static void dropWhile() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> result = list.stream().dropWhile(i -> i < 4).collect(Collectors.toList());
        System.out.println(result);
    }

    private static void ofNull() {
        Stream<String> stream = Stream.ofNullable(null);
        System.out.println(stream);
    }

    private static void iterator() {
        Stream<String> stream = Stream.of("a", "b", "c");
        Iterator<String> iterator = stream.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
