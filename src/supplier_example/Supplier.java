package supplier_example;
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
