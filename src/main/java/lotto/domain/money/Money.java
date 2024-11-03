package lotto.domain.money;

import static lotto.ErrorCode.*;

public class Money {

    private int amount;

    public Money(String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validate(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
