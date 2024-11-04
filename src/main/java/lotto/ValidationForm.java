package lotto;

import java.util.function.Consumer;

public class ValidationForm<T> {
    private final T value;

    public ValidationForm(T value, Consumer<T> consumer) {
        consumer.accept(value);
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
