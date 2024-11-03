package lotto.service;

import static lotto.view.InputController.purchase;

public class InputService {
    public static int lottoAmount;

    public static void validatePurchase() {
        if (purchase < 1000) {
            throw new IllegalArgumentException("[ERROR] 1,000원 이상부터 구매 가능합니다.");
        }
    }

    public static void getLottoAmount() {
        if (purchase % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 구입 가능합니다.");
        }
        lottoAmount = purchase/1000;
    }
}
