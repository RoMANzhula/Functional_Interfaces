package predicate_example;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

}

