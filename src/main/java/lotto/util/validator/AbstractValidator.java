package lotto.util.validator;

import java.util.regex.Pattern;
import lotto.util.ExceptionMessage;

public abstract class AbstractValidator implements Validator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]+$");

    @Override
    public void validate(String userInput) throws IllegalArgumentException {
        String trimmedInput = Validator.removeSpace(userInput);
        validateNumber(trimmedInput);
        performSpecificValidation(trimmedInput);
    }

    protected abstract void performSpecificValidation(String input) throws IllegalArgumentException;

    protected void validateNumber(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }
}