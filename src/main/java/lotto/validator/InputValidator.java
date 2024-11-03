package lotto.validator;

public interface InputValidator<T> {
    String ERROR_MESSAGE = "[ERROR]";

    T validate(String input) throws IllegalArgumentException;
}
