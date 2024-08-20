package demo;

import java.util.List;
import java.util.Map;

public class VarDemo {
    public static void main(String[] args) {
        var number = 10; // 推断为 int
        var text = "Hello, Java 11"; // 推断为 String
        var list = List.of(1, 2, 3); // 推断为 List<Integer>

        System.out.println(number);
        System.out.println(text);
        System.out.println(list);

        var map = Map.of("key1", 1, "key2", 2); // 推断为 Map<String, Integer>

        for (var entry : map.entrySet()) { // 推断为 Map.Entry<String, Integer>
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
