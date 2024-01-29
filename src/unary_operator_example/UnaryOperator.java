package unary_operator_example;
@FunctionalInterface
public interface UnaryOperator<T> {
    T apply(T t);
}
