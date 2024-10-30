package lotto.utils.validator;

import static lotto.utils.ErrorMessage.EMPTY_INPUT_ERROR_MESSAGE;

import lotto.utils.Constant;

public abstract class Validator {

    protected void validateEmpty(String userInput) {
        if (userInput.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE.toString());
        }
    }

    public void validateNumber(String userInput, String errorMessage) {
        if (!userInput.matches(Constant.INTEGER_REGEX)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public abstract void validate(String userInput);
}
