package demo;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        Optional<String> opt = Optional.of("test");
        System.out.println(opt.isEmpty());

        Optional<String> opt2 = Optional.empty();
        System.out.println(opt2.isEmpty());
    }
}
