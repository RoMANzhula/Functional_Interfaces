package consumer_example;
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}

//Consumer (с англ. — “потребитель”) — функциональный интерфейс, который принимает в качестве
// входного аргумента объект типа T, совершает некоторые действия, но при этом ничего не возвращает:
