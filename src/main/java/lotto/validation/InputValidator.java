package lotto.validation;

@FunctionalInterface
public interface InputValidator<T> {
    T validate(String input) throws IllegalArgumentException;
}
