package lotto.domain.lotto;

import lotto.exception.TicketException;
import lotto.exception.message.TicketExceptionMessage;

public class Ticket {

    private int count;

    public Ticket(int money) {
        validateMoneyAmount(money);
        validateMoneyUnit(money);
        this.count = money / 1000;
    }

    private void validateMoneyUnit(int money) {
        if (money % 1000 != 0) {
            throw new TicketException(TicketExceptionMessage.INVALID_MONEY_UNIT);
        }
    }

    private void validateMoneyAmount(int money) {
        if (money < 1000) {
            throw new TicketException(TicketExceptionMessage.INVALID_MONEY_AMOUNT);
        }
    }

    public int getCount() {
        return this.count;
    }

}
