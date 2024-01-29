package function_example;
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
