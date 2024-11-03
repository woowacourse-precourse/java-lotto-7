package lotto.model;

import static lotto.constant.ErrorMessages.INVALID_MONEY;

public class LottoTickets {

    private static final int PRICE_PER_TICKET = 1000;
    private int ticketCount;

    public LottoTickets(String stringMoney) {
        int money = parsePositiveNumber(stringMoney);
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
