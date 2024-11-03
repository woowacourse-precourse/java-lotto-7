package lotto.domain;

import static lotto.constants.LottoConstants.*;

import lotto.Validator.AmountValidator;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount) {
        AmountValidator.validateAmount(amount);
        this.amount = amount;
    }

    public int calculateNumberOfLottos() {
        return amount / LOTTO_PRICE;
    }
}
