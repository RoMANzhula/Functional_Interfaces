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

//UnaryOperator — функциональный интерфейс, принимает в качестве параметра объект типа T, выполняет над ним
// некоторые операции и возвращает результат операций в виде объекта того же типа T