package lotto.domain;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoConstant.*;

public class PurchaseAmount {

    private final Integer purchaseAmount;

    public PurchaseAmount(Integer purchaseAmount) {
        validateIsMultipleOfLottoPrice(purchaseAmount);
        validateIsNotZero(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }

    private void validateIsMultipleOfLottoPrice(int purchaseAmount) {
        if (isNotMultipleOfLottoPrice(purchaseAmount)) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.getMessage());
        }
    }

    private void validateIsNotZero(int purchaseAmount) {
        if (purchaseAmount == INT_ZERO.getValue()) {
            throw new IllegalArgumentException(INVALID_ZERO_AMOUNT.getMessage());
        }
    }

    private boolean isNotMultipleOfLottoPrice(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE.getValue() != INT_ZERO.getValue();
    }
}
