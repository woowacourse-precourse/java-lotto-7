package lotto.model;

import lotto.util.Constants;
import lotto.util.MessageParser;
import lotto.validator.Errors;

/*
로또 구입금액
*/
public class Money {
    private final long amount;

    public Money(long amount) {
        validate(amount);
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    private void validate(long amount) {
        validateRange(amount);
        validateNoRemainder(amount);
    }

    protected void validateRange(long amount) {
        if (amount < Constants.MIN_MONEY.getNumber()
                || amount > Constants.MAX_MONEY.getLong()) {
            throw new IllegalArgumentException(MessageParser.combineMessages(Errors.NOT_IN_RANGE.getMessage()));
        }
    }

    protected void validateNoRemainder(long amount) {
        if (amount % Constants.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(MessageParser.combineMessages(Errors.REMAINDER_EXISTENT.getMessage()));
        }
    }
}
