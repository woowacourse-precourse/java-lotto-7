package lotto.domain;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int amount) {
        validateMinimumAmount(amount);
        this.amount = amount;
    }

    private void validateMinimumAmount(int value) {
        if (value < LottoConstant.LOTTO_PRICE.getValue()) {
            ExceptionMessage message = ExceptionMessage.MINIMUM_AMOUNT;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    public int getLottoCount() {
        return this.amount / LottoConstant.LOTTO_PRICE.getValue();
    }
}
