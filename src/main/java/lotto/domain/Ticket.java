package lotto.domain;

import static lotto.constants.Constants.MONEY_UNIT;

import lotto.vo.Money;

public class Ticket {
    private final int ticket;

    private Ticket(int ticket) {
        this.ticket = ticket;
    }

    public static Ticket of(Money money) {
        return new Ticket(publishTicket(money));
    }

    public int getTicket() {
        return ticket;
    }

    private static int publishTicket(Money money) {
        return money.money() / MONEY_UNIT;
    }
}
