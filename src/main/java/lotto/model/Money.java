package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.Limit;
import lotto.util.Message;

public class Money {
    private final int amount;

    private Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    public Ticket toTickets() {
        int ticketCount = this.amount / Limit.UNIT_PRICE.getValue();
        return new Ticket(ticketCount);
    }

    private void validate(int amount) {
        validateRange(amount);
        validateDividableUnitPrice(amount);
    }

    private void validateRange(int amount) {
        if (amount < Limit.MIN_AMOUNT.getValue() || amount > Limit.MAX_AMOUNT.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_TAG.getSentence()
                    + ErrorMessage.MONEY_RANGE.getError());
        }
    }

    private void validateDividableUnitPrice(int amount) {
        if (amount % Limit.UNIT_PRICE.getValue() != Limit.DEFAULT.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_TAG.getSentence()
                    + ErrorMessage.MONEY_UNIT.getError());
        }
    }
}
