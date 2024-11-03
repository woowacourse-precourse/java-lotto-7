package lotto.application.validation;

public interface BaseValidation<T> {
    T validate(String input);
}
