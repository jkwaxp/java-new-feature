package demo;

import bean.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法引用示例
 */
public class MethodRefDemo {

    public static void main(String[] args) {
        Person person = ((Supplier<Person>)Person::new).get();
        person.setName("John");

        List<Person> list = Arrays.asList(person);
        list.forEach(System.out::print);
    }
}
