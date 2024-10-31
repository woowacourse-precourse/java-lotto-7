package lotto.validation;

import static lotto.constant.LotteryConstant.DEFAULT_ERROR_MESSAGE;

public class LotteryValidator {

    // 숫자로 변환된 구매 금액
    public void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(DEFAULT_ERROR_MESSAGE + "로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

}
