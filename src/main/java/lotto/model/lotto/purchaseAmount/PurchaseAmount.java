package lotto.model.lotto.purchaseAmount;

import static lotto.common.Exceptions.NOT_DIVISIBLE_BY_LOTTO_PRICE;
import static lotto.model.lotto.lottoNumber.LotteryRule.LOTTO_PRICE;

public record PurchaseAmount(int purchaseAmount) {
    public PurchaseAmount {
        validate(purchaseAmount);
    }

    public int calculateLottoAmount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_LOTTO_PRICE.getMessage());
        }
    }
}
