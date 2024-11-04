package lotto.validator;

import java.util.regex.Pattern;
import lotto.util.Errors;
import lotto.util.MessageParser;
import lotto.util.Regex;
import org.assertj.core.util.VisibleForTesting;

public class Validator {

    final String input;

    public Validator(String input) {
        this.input = input;
    }

    void validate() {
        validateNotNull();
        validateNotEmpty();
        validateWholeNumber();
    }

    @VisibleForTesting
    void validateNotNull() {
        if (input == null) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NULL_OR_EMPTY_INPUT.getMessage()));
        }
    }

    @VisibleForTesting
    void validateNotEmpty() {
        if (input.isBlank()) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NULL_OR_EMPTY_INPUT.getMessage()));
        }
    }


    @VisibleForTesting
    void validateWholeNumber() {
        if (!Pattern.matches(Regex.INTEGER.getValue(), input)) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NOT_A_WHOLE_NUMBER.getMessage()));
        }
    }
}
