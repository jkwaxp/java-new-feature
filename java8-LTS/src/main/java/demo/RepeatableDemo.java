package demo;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RepeatableDemo {

    public static void main(String[] args) {
        MyAnnotations annotations = MyClass.class.getAnnotation(MyAnnotations.class);
        for (MyAnnotation annotation : annotations.value()) {
            System.out.println(annotation.value());
        }
    }

    @Repeatable(MyAnnotations.class)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotation {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotations {
        MyAnnotation[] value();
    }

    @MyAnnotation("a")
    @MyAnnotation("b")
    class MyClass{

    }
}
