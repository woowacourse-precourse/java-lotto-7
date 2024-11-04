package lotto.model.domain;

import static lotto.constant.ErrorMessages.INVALID_MONEY_ERROR;
import static lotto.constant.LottoGameConfig.TICKET_PRICE;

import lotto.util.InputParser;

public class LottoTickets {

    private final int ticketCount;

    public LottoTickets(String stringMoney) {
        int money = InputParser.parsePositiveNumber(stringMoney, INVALID_MONEY_ERROR);
        validateTicketPrice(money);
        ticketCount = money / TICKET_PRICE;
    }

    private void validateTicketPrice(int money) {
        if (money % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_ERROR);
        }
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
