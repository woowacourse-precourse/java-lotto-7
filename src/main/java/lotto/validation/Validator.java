package lotto.validation;

public interface Validator<T> {
    void validate(T value);
}
