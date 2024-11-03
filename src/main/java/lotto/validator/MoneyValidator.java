package lotto.validator;

import lotto.util.Errors;
import lotto.util.InputParser;
import lotto.util.MessageParser;
import org.assertj.core.util.VisibleForTesting;

public class MoneyValidator extends Validator {
    
    public MoneyValidator(String input) {
        super(input);
    }

    public void validate() {
        super.validate();
        validateLong();
    }

    @VisibleForTesting
    void validateLong() {
        try {
            InputParser.parseLong(super.input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NOT_A_LONG.getMessage()));
        }
    }
}
