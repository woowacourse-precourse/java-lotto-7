package lotto.common.validator;

import lotto.common.LottoConfig;

public class IssuedLottoValidator {
    public static void validate(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount == 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 이상 입력해주세요.");
        }
        if (isInvalidPurchaseAmount(lottoPurchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해주세요.");
        }
        if (lottoPurchaseAmount > LottoConfig.LOTTO_PURCHASE_LIMIT.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 10,000원 이하로 입력해주세요.");
        }
    }

    private static boolean isInvalidPurchaseAmount(int lottoPurchaseAmount) {
        return lottoPurchaseAmount % LottoConfig.LOTTO_PRICE.getValue() != 0;
    }
}
