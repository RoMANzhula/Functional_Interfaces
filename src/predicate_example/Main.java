package predicate_example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isEventNumber = x -> x % 2 == 0;

        System.out.println(isEventNumber.test(4)); //true
        System.out.println(isEventNumber.test(3)); //false

        //example with Stream.filter()
        List<Integer> eventNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("---------");
        System.out.println(eventNumbers); //output array with only event numbers [2, 4, 6, 8]

    }
}

// Predicate - функціональний інтерфейс для перевірки дотримання певної умови. Якщо умова дотримується,
// повертає true, інакше - false
