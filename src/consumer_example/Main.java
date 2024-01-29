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

//Consumer (с англ. — “потребитель”) — функциональный интерфейс, который принимает в качестве входного
// аргумента объект типа T, совершает некоторые действия, но при этом ничего не возвращает.
