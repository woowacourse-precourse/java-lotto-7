package lotto.util.validator;

import java.util.regex.Pattern;
import lotto.util.ExceptionMessage;

public abstract class AbstractValidator implements Validator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]+$");

    @Override
    public void validate(String userInput) throws IllegalArgumentException {
        String trimmedInput = Validator.removeSpace(userInput);
        validateNumber(trimmedInput);  // 공통 숫자 검증 로직
        performSpecificValidation(trimmedInput); // 개별 구현체에서 추가할 검증
    }

    protected abstract void performSpecificValidation(String input) throws IllegalArgumentException;

    protected void validateNumber(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }
}