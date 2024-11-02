package lotto.validator;

import java.util.regex.Pattern;
import lotto.util.Errors;
import lotto.util.MessageParser;
import org.assertj.core.util.VisibleForTesting;

public class MoneyValidator extends Validator {
    private final String money;

    public MoneyValidator(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }

    public void validate() {
        validateNotNull();
        validateNotEmpty();
        validateWholeNumber();
        validateLong();
    }

    @VisibleForTesting
    void validateNotNull() {
        if (money == null) {
            throw new IllegalArgumentException(MessageParser.combineMessages(Errors.NULL_OR_EMPTY_INPUT.getMessage()));
        }
    }

    @VisibleForTesting
    void validateNotEmpty() {
        if (money.isBlank()) {
            throw new IllegalArgumentException(MessageParser.combineMessages(Errors.NULL_OR_EMPTY_INPUT.getMessage()));
        }
    }

    @VisibleForTesting
    void validateWholeNumber() {
        if (!Pattern.matches("-?\\d+", money)) {
            throw new IllegalArgumentException(MessageParser.combineMessages(Errors.NOT_A_WHOLE_NUMBER.getMessage()));
        }
    }

    @VisibleForTesting
    void validateLong() {
        try {
            Long.parseLong(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageParser.combineMessages(Errors.NOT_A_LONG.getMessage()));
        }
    }
}
