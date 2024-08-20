package demo;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalDemo {

    public static void main(String[] args) {
        //stream
        Stream<String> stream = Optional.of("test").stream();
        System.out.println(stream);
        //ifPresentOrElse
        Optional.of("test").ifPresentOrElse(e -> System.out.println(e), () -> {});
        Optional.empty().ifPresentOrElse(e -> System.out.println(e), () -> System.out.println("empty action"));
        //or
        System.out.println(Optional.of("test").or(() ->  Optional.of("default")));
        System.out.println(Optional.empty().or(() ->  Optional.of("default")));
    }
}
