package lotto.validator;

import lotto.constants.LottoConstants;

public class PurchaseAmountValidator {
    public static void validate(int amount) {
        if (amount < LottoConstants.LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 최소 1,000원 이상이어야 합니다.");
        }
        if (amount % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
