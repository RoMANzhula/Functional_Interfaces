package function_example;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Function<String, Integer> valueConverter = x -> Integer.valueOf(x);
        System.out.println(valueConverter.apply("678")); //output Integer 678

        //example with Stream.map()
        List<Integer> values = Stream.of("32", "43", "74", "54", "3")
                .map(x -> Integer.valueOf(x))
                .collect(Collectors.toList());

        System.out.println(values); //output [32, 43, 74, 54, 3]  String -> Integer
    }

}

// Function - цей функціональний інтерфейс приймає аргумент T і наводить його до об'єкта типу R,
// який і повертається як результат

// Метод map, який приймає елементи одного типу, щось з ними робить і передає далі, але це
// може бути елементи іншого типу
