package lotto.service.input;

public interface InputService<T> {
    void validate(String input);
    T get();
}
