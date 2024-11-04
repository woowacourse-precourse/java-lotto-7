package lotto.domain;

import lotto.error.ErrorMessage;

public class Player {
    private final int money;
    private final int ticketQuantity;

    public Player(int money, int ticketQuantity) {
        validate(money);
        this.money = money;
        this.ticketQuantity = ticketQuantity;
    }

    private void validate(int money){
        if (money <= 0 || money % 1000 != 0) {
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
