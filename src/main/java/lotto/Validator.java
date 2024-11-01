package lotto;

import static lotto.LottoConstant.PRICE;

public class Validator {

    public static void validatePurchaseAmount(long input) {
        if (input % 1000 != 0 || input / 1000 < 1) {
            throw new IllegalArgumentException("구매 금액은 " + PRICE + "원 단위로 입력해야 합니다.");
        }
    }
}
