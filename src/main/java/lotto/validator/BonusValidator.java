package lotto.validator;

import java.util.regex.Pattern;
import lotto.util.Errors;
import lotto.util.InputParser;
import lotto.util.MessageParser;
import org.assertj.core.util.VisibleForTesting;

public class BonusValidator extends Validator {
    private final String bonus;

    public BonusValidator(String bonus) {
        this.bonus = bonus;
    }

    public void validate() {
        validateNotNull();
        validateNotEmpty();
        validateWholeNumber();
        validateInteger();
    }

    @VisibleForTesting
    void validateNotNull() {
        if (bonus == null) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NULL_OR_EMPTY_INPUT.getMessage()));
        }
    }

    @VisibleForTesting
    void validateNotEmpty() {
        if (bonus.isBlank()) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NULL_OR_EMPTY_INPUT.getMessage()));
        }
    }

    @VisibleForTesting
    void validateWholeNumber() {
        if (!Pattern.matches("-?\\d+", bonus)) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NOT_A_WHOLE_NUMBER.getMessage()));
        }
    }

    @VisibleForTesting
    void validateInteger() {
        try {
            InputParser.parseInt(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NOT_INTEGER.getMessage()));
        }
    }
}
