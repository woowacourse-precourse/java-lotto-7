package lotto.model.domain;

import static lotto.constant.ErrorMessages.INVALID_MONEY;

public class LottoTickets {

    private static final int PRICE_PER_TICKET = 1_000;
    private final int purchasePrice;
    private int ticketCount;

    public LottoTickets(String stringMoney) {
        int money = parsePositiveNumber(stringMoney);
        if (money % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }

        purchasePrice = money;
        ticketCount = money / PRICE_PER_TICKET;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public boolean hasTicketCount() {
        return ticketCount > 0;
    }

    public void decreaseTicketCount() {
        ticketCount--;
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
