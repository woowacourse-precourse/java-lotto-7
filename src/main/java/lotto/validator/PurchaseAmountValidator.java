package lotto.validator;

import lotto.constants.Constants;

public class PurchaseAmountValidator {
    public static void validate(int amount) {
        if (amount < Constants.LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 최소 1,000원 이상이어야 합니다.");
        }
        if (amount % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
