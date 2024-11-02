package lotto.validator;

import java.util.regex.Pattern;
import lotto.util.Constants;

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
        validateRange();
        validateNoRemainder();
    }

    protected void validateNotNull() {
        if (money == null) {
            throw new IllegalArgumentException(combineMessages(Errors.NULL_OR_EMPTY_INPUT.getMessage()));
        }
    }

    protected void validateNotEmpty() {
        if (money.isBlank()) {
            throw new IllegalArgumentException(combineMessages(Errors.NULL_OR_EMPTY_INPUT.getMessage()));
        }
    }

    protected void validateWholeNumber() {
        if (!Pattern.matches("-?\\d+", money)) {
            throw new IllegalArgumentException(combineMessages(Errors.NOT_A_NATURAL_NUMBER.getMessage()));
        }
    }

    protected void validateLong() {
        try {
            Long.parseLong(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(combineMessages(Errors.NOT_A_LONG.getMessage()));
        }
    }

    protected void validateRange() {
        if (Long.parseLong(money) < Constants.MIN_MONEY.getNumber()
                || Long.parseLong(money) > Constants.MAX_MONEY.getLong()) {
            throw new IllegalArgumentException(combineMessages(Errors.NOT_IN_RANGE.getMessage()));
        }
    }

    protected void validateNoRemainder() {
        if (Long.parseLong(money) % Constants.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(combineMessages(Errors.REMAINDER_EXISTENT.getMessage()));
        }
    }
}
