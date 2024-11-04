package lotto.service;

import static lotto.constant.ApplicationConstants.LOTTO_PRICE;

import lotto.enums.ErrorMessage;

public class AmountValidatorService {
    public void checkPurchaseAmount(int purchaseAmount) {
        if ((purchaseAmount % LOTTO_PRICE) != 0 || purchaseAmount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

}
