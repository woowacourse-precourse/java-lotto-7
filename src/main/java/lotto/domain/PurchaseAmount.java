package lotto.domain;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoConstant.*;

public record PurchaseAmount(Integer amount) {

    public PurchaseAmount {
        validateIsMultipleOfLottoPrice(amount);
        validateIsNotZero(amount);
    }

    private void validateIsMultipleOfLottoPrice(int amount) {
        if (isNotMultipleOfLottoPrice(amount)) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.getMessage());
        }
    }

    private void validateIsNotZero(int amount) {
        if (amount == INT_ZERO.getValue()) {
            throw new IllegalArgumentException(INVALID_ZERO_AMOUNT.getMessage());
        }
    }

    private boolean isNotMultipleOfLottoPrice(int amount) {
        return amount % LOTTO_PRICE.getValue() != INT_ZERO.getValue();
    }
}
