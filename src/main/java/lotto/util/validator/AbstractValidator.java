package lotto.util.validator;

import java.util.regex.Pattern;
import lotto.util.ExceptionMessage;

public abstract class AbstractValidator<T> implements Validator<T> {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]+$");

    @Override
    public T validate(String userInput) throws IllegalArgumentException {
        String trimmedInput = Validator.removeSpace(userInput);
        validateNumber(trimmedInput);
        return convertAndValidate(trimmedInput);
    }

    protected abstract T convertAndValidate(String input) throws IllegalArgumentException;

    protected void validateNumber(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }
}