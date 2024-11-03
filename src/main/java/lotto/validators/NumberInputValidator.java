package lotto.validators;

import lotto.validators.constants.ErrorMessages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface NumberInputValidator {
    String POSITIVE_WHOLE_INT_REGEX = "^[1-9][0-9]*$";

    default void checkInputType(String input) {
        Pattern inputPattern = Pattern.compile(POSITIVE_WHOLE_INT_REGEX);
        Matcher matcher = inputPattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessages.INCORRECT_TYPE.getMessage());
        }
    }
}
