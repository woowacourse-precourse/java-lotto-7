package lotto.service;

import static lotto.exception.ErrorMessage.INVALID_PURCHASE_MONEY;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    public void validatePurchaseMoney(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_MONEY.getMessage());
        }
    }
}
