package lotto.model;

import lotto.constants.ErrorMessage;

public class Money {

    private static final int PRICE_MINIMUM = 0;
    private static final int TICKET_PRICE = 1000;
    private final int price;

    public Money(int price) {
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        if (isInvalid(price)) {
            throw new IllegalArgumentException(ErrorMessage.IS_INVALID_PRICE.getMessage());
        }
    }

    private boolean isInvalid(int price) {
        return price <= PRICE_MINIMUM || price % TICKET_PRICE != 0;
    }

    public int getLottoTicketCount() {
        return price / TICKET_PRICE;
    }
}
