package unary_operator_example;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        UnaryOperator<Integer> squareValue = x -> x * x;
        System.out.println(squareValue.apply(9)); //output 81

        //example with Stream.iterate()
        Stream.iterate(9, x -> x * x)
                .limit(4)
                .forEach(System.out::println); //output 9->91->6561->43046721
    }
}

// UnaryOperator - функціональний інтерфейс, приймає як параметр об'єкт типу T, виконує над ним
// деякі операції та повертає результат операцій у вигляді об'єкта того ж типу T
