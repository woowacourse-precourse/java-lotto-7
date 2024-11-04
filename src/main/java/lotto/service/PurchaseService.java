package lotto.service;

import lotto.ErrorMessage;

public class PurchaseService {
    public int getTicketCount(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE.toString());
        }
        return price / 1000;
    }
}
