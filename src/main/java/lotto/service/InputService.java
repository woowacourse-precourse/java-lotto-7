package lotto.service;

import lotto.view.InputController;

public class InputService {
    public static int lottoAmount;

    public static void getLottoAmount() {
        if (InputController.purchase % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 구입 가능합니다.");
        }
        lottoAmount = InputController.purchase/1000;
    }
}
