package lotto.domain;

import static lotto.utils.Constants.THOUSAND_VALUE;
import static lotto.utils.Constants.ZERO_VALUE;

import lotto.utils.ErrorMessage;

public class Player {
    private final int money;
    private final int ticketQuantity;

    public Player(int money, int ticketQuantity) {
        validate(money);
        this.money = money;
        this.ticketQuantity = ticketQuantity;
    }

    private void validate(int money) {
        if (money <= ZERO_VALUE || money % THOUSAND_VALUE != ZERO_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_OUT_OF_RANGE.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }
}
