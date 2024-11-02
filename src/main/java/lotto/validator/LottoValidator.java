package lotto.validator;

import java.util.Arrays;
import java.util.regex.Pattern;
import lotto.util.Errors;
import lotto.util.InputParser;
import lotto.util.MessageParser;
import lotto.util.Regex;
import org.assertj.core.util.VisibleForTesting;

public class LottoValidator extends Validator {
    public LottoValidator(String input) {
        super(input);
    }

    public void validate() {
        super.validate();
        validateListOfInteger();
    }

    @VisibleForTesting
    @Override
    void validateWholeNumber() {
        if (Arrays.stream(super.input.split(Regex.COMMA.getValue()))
                .anyMatch(number -> !Pattern.matches("-?\\d+", number))) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NOT_A_WHOLE_NUMBER.getMessage()));
        }
    }

    @VisibleForTesting
    void validateListOfInteger() {
        try {
            InputParser.parseListOfInteger(super.input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NOT_INTEGER.getMessage()));
        }
    }
}
