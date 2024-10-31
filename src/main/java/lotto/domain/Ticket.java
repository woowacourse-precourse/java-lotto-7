package lotto.domain;

import static lotto.domain.Amount.*;

public class Ticket {

    private final Integer number;

    public Ticket(int inputAmount) {
        Amount amount = new Amount(inputAmount);
        this.number = calculateTicket(amount);
    }

    public Integer getNumber() {
        return number;
    }

    private int calculateTicket(Amount amount) {
        return amount.getAmount() / LOTTO_PRICE;
    }
}
