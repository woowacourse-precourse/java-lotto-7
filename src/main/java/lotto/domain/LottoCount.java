package lotto.domain;

import static lotto.error.ErrorType.INVALID_PURCHASE_PRICE;

import lotto.error.exception.InvalidLottoAmountException;

public class LottoCount {
    int count;

    public LottoCount(final int purchaseAmount, final int lottoPrice) {
        validatePurchaseAmount(purchaseAmount, lottoPrice);
        this.count = purchaseAmount / lottoPrice;
    }

    private void validatePurchaseAmount(final int purchaseAmount, final int lottoPrice) {
        if (purchaseAmount % lottoPrice != 0) {
            throw new InvalidLottoAmountException(INVALID_PURCHASE_PRICE);
        }
    }

    public int getCount() {
        return count;
    }
}
