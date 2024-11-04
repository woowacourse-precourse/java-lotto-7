package lotto.utils.validator;

public interface Validator<T> {
    String ErrorMessage = "[ERROR]";

    void validate(T value);
}
