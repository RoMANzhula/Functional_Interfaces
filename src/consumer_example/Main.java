package consumer_example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Consumer<String> greetings = x -> System.out.println("Hello " + x + " !!!");

        greetings.accept("Mark");
        greetings.accept("Inna Victorivna");

        //example with Stream.peek()
        System.out.println("-----------------");

        List<String> peopleGreetings = Stream.of("Inna", "Mark", "Alfa", "Roman")
                .peek(x -> System.out.println("Hello from Stream, " + x + " !!!"))
                .collect(Collectors.toList());


    }
}

// Consumer (з англ. - "споживач") - функціональний інтерфейс, який приймає як
// вхідний аргумент об'єкт типу T, здійснює деякі дії, але при цьому нічого не повертає:
