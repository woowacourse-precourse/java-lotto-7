package lotto.util.validation;

import static lotto.exception.ExceptionMessage.NOT_MUST_BE_NULL;

public abstract class AbstractValidator<T> implements Validator<T> {
    public void validateNotNull(T target) {
        if (target == null) {
            throwFail(NOT_MUST_BE_NULL.format());
        }
    }

    public void throwFail(String exceptionMessage) {
        throw new IllegalArgumentException(exceptionMessage);
    }
}