package lotto.validator;

import lotto.util.Errors;
import lotto.util.InputParser;
import lotto.util.MessageParser;
import org.assertj.core.util.VisibleForTesting;

public class BonusValidator extends Validator {
    
    public BonusValidator(String input) {
        super(input);
    }

    public void validate() {
        super.validate();
        validateInteger();
    }

    @VisibleForTesting
    void validateInteger() {
        try {
            InputParser.parseInt(super.input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NOT_INTEGER.getMessage()));
        }
    }
}
