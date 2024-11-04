package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.error.ErrorType.INVALID_PURCHASE_PRICE;

import lotto.error.exception.InvalidLottoAmountException;

public class LottoCount {
    int count;

    public LottoCount(final int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.count = purchaseAmount / LOTTO_PRICE;
    }

    private void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new InvalidLottoAmountException(INVALID_PURCHASE_PRICE);
        }
    }

    public int getCount() {
        return count;
    }
}
