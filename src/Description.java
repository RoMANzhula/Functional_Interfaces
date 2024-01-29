public class Description {
    public static void main(String[] args) {

    }
}

                    //Consumer (потребитель)
//Consumer — это функциональный интерфейс, который принимает один параметр на вход и не возвращает никаких
// выходных данных. На языке непрофессионала, как следует из названия, реализация этого интерфейса потребляет
// вводимые данные. Пользовательский интерфейс имеет два метода:
//void accept(T t);
//default Consumer<T> andThen(Consumer<? super T> after);
//Метод accept является единым абстрактным методом (SAM), который принимает один аргумент типа T. Тогда как
// другой метод andThen является методом по умолчанию и используется для композиции.

//Ниже приведен пример интерфейса consumer. Мы создали потребительскую реализацию, которая использует строку, а
// затем просто выводит ее на экран. Метод forEach принимает реализацию потребительского интерфейса.

//public void whenNamesPresentConsumeAll() {
//	Consumer<String> printConsumer = t -> System.out.println(t);
//	Stream<String> cities = Stream.of("Sydney", "Dhaka", "New York", "London");
//	cities.forEach(printConsumer);
//}
//В следующем примере демонстрируется использование составления нескольких реализаций интерфейса consumer для
// создания цепочки потребителей.
//Ниже мы создали двух потребителей: один преобразует список элементов в строки верхнего регистра, а другой
// выводит строку верхнего регистра.
//
//public void whenNamesPresentUseBothConsumer() {
//    List<String> cities = Arrays.asList("Sydney", "Dhaka", "London");
//
//    Consumer<List<String>> upperCaseConsumer = list -> {
//        for(int i=0; i< list.size(); i++){
//            list.set(i, list.get(i).toUpperCase());
//        }
//    };
//    Consumer<List<String>> printConsumer = list -> list.stream()
//      												.forEach(System.out::println);
//
//    upperCaseConsumer.andThen(printConsumer).accept(cities);
//}
//Интерфейс Consumer имеет специфические типы реализаций для типов integer, double и long -> IntConsumer,
// DoubleConsumer и LongConsumer, как показано ниже:
//
//IntConsumer void accept(int x);
//DoubleConsumer void accept(double x);
//LongConsumer void accept(long x);


                            //Supplier (поставщик)
//Supplier — это простой интерфейс, указывающий, что данная реализация является поставщиком какого то
// результа. Этот интерфейс, однако, не накладывает никаких дополнительных ограничений, которые реализация
// поставщика должна возвращать при каждом новом получении результата.
//
//У поставщика есть только один метод get() и нет никаких других методов по умолчанию или статических методов.
//
//public void supplier() {
//    Supplier<Double> doubleSupplier1 = () -> Math.random();
//    DoubleSupplier doubleSupplier2 = Math::random;
//
//    System.out.println(doubleSupplier1.get());
//    System.out.println(doubleSupplier2.getAsDouble());
//}
//Интерфейс поставщик имеет свои примитивные варианты, такие как IntSupplier, DoubleSupplier и т. д., как
// показано ниже. Обратите внимание, что имя метода — get() используется для универсального интерфейса
// поставщика. Однако для примитивных вариантов этот метод соответствует примитивному типу.
//
//IntSupplier int getAsInt();
//DoubleSupplier double getAsDouble();
//LongSupplier long getAsLong();
//BooleanSupplier boolean getAsBoolean();
//Одно из основных применений этого интерфейса это использование для включения отложенного выполнения. Это
// означает отсрочку выполнения до тех пор, пока оно не понадобится. Например, в классе Optional есть метод
// orElseGet. Этот метод срабатывает, если у option нет данных. Это показано ниже:
//
//public void supplierWithOptional() {
//    Supplier<Double> doubleSupplier = () -> Math.random();
//    Optional<Double> optionalDouble = Optional.empty();
//    System.out.println(optionalDouble.orElseGet(doubleSupplier));
//}


                                    //Predicate (предикат)
//Интерфейс Predicate представляет собой логическую функцию аргумента. Он в основном используется для
// фильтрации данных из потока (stream) Java. Метод фильтра потока принимает предикат для фильтрации
// данных и возврата нового потока, удовлетворяющего предикату. У предиката есть метод test(), который
// принимает аргумент и возвращает логическое значение.
//
//public void testPredicate() {
//    List<String> names = Arrays.asList("Smith", "Samueal", "Catley", "Sie");
//    Predicate<String> nameStartsWithS = str -> str.startsWith("S");
//    names.stream().filter(nameStartsWithS).forEach(System.out::println);
//}
//В приведенном выше примере мы создали предикат, который проверяет имена, начинающиеся с S. Этот
// предикат передается потоку.
//
//Predicate также предоставляет несколько стандартных и статических методов для композиции и других целей:
//
//default Predicate<T> and(Predicate<? super T> other);
//default Predicate<T> or(Predicate<? super T> other);
//static <T> Predicate<T> isEquals(Object targetRef);
//default Predicate<T> negate();
//В следующем примере демонстрируется использование и метод для составления цепочки предикатов.
//
//public void testPredicateAndComposition() {
//    List<String> names = Arrays.asList("Smith", "Samueal", "Catley", "Sie");
//    Predicate<String> startPredicate = str -> str.startsWith("S");
//    Predicate<String> lengthPredicate = str -> str.length() >= 5;
//    names.stream()
//      .filter(startPredicate.and(lengthPredicate))
//      .forEach(System.out::println);
//}


                                    //Function (функция)
//Интерфейс Function — это более общий интерфейс, который принимает один аргумент и выдает результат. В нем
// применяется единый абстрактный метод (SAM), который принимает аргумент типа T и выдает результат
// типа R. Одним из распространенных вариантов использования этого интерфейса является метод Stream.map.
// Пример использования показан ниже:
//
//public void testFunctions() {
//    List<String> names = Arrays.asList("Smith", "Gourav", "John", "Catania");
//    Function<String, Integer> nameMappingFunction = String::length;
//    List<Integer> nameLength = names.stream()
//      .map(nameMappingFunction).collect(Collectors.toList());
//    System.out.println(nameLength);
//}