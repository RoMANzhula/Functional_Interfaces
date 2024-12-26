package supplier_example;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Inna");
        nameList.add("Mark");
        nameList.add("Alfa");
        nameList.add("Roman");

        Supplier<String> randomName = () -> {
            int value = (int)(Math.random() * nameList.size());
            return nameList.get(value);
        };

        System.out.println(randomName.get());

        //example with Stream.generate()
        System.out.println("-------");
        Stream.generate(() -> {
            int value = (int) (Math.random() * nameList.size());
            return  nameList.get(value);
        }).limit(4).forEach(System.out::println); //output four random name from List
    }
}

// Supplier (з англ. - Постачальник) - функціональний інтерфейс, який не приймає жодних аргументів,
// але повертає деякий об'єкт типу T
