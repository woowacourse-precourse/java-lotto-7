package lotto.model.lotto.validator;

import static lotto.util.LottoConstants.LOTTO_PURCHASE_AMOUNT;

public class LottoStoreValidator {
    public static void validate(Long purchaseAmount) {
        validatePositiveAmount(purchaseAmount);
        validateAmountUnit(purchaseAmount);
    }

    private static void validatePositiveAmount(Long purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
    }

    private static void validateAmountUnit(Long purchaseAmount) {
        if (purchaseAmount % LOTTO_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LOTTO_PURCHASE_AMOUNT + "원 단위여야 합니다.");
        }
    }
}
