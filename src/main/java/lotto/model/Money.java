package lotto.model;

import lotto.util.Constants;
import lotto.util.Errors;
import lotto.util.MessageParser;
import org.assertj.core.util.VisibleForTesting;

/**
 * 로또 구입금액
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

    @VisibleForTesting
    void validateRange(long amount) {
        if (isOutOfRange(amount)) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NOT_IN_MONEY_RANGE.getMessage()));
        }
    }

    private boolean isOutOfRange(long number) {
        return number < Constants.MIN_MONEY.getNumber() || number > Constants.MAX_MONEY.getLong();
    }

    @VisibleForTesting
    void validateNoRemainder(long amount) {
        if (amount % Constants.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.REMAINDER_EXISTENT.getMessage()));
        }
    }
}
