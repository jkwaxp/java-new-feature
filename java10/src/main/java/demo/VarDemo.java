package demo;

import java.util.Arrays;

public class VarDemo {

    public static void main(String[] args) {
        var list = Arrays.asList("hello", "world");
        System.out.println(list);
        System.out.println(list.getClass().getName());
    }
}
