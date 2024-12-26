package consumer_example;
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}

// Consumer (з англ. - "споживач") - функціональний інтерфейс, який приймає як
// вхідний аргумент об'єкт типу T, здійснює деякі дії, але при цьому нічого не повертає:
