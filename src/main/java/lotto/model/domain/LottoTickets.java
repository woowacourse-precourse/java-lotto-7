package lotto.model.domain;

import static lotto.constant.ErrorMessages.INVALID_MONEY;
import static lotto.constant.LottoGameConfig.TICKET_PRICE;

public class LottoTickets {

    private int ticketCount;

    public LottoTickets(String stringMoney) {
        int money = parsePositiveNumber(stringMoney);
        if (money % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }

        ticketCount = money / TICKET_PRICE;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    private int parsePositiveNumber(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }

        try {
            int intNumber = Integer.parseInt(number);
            if (intNumber <= 0) {
                throw new IllegalArgumentException(INVALID_MONEY);
            }
            return intNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }
    }
}
