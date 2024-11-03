package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void draw() {
        int purchaseAmount = inputPurchaseAmountRecursion();
    }

    private int inputPurchaseAmountRecursion() {
        try {
            OutputView.requestInputPurchaseAmount();
            int purchaseAmount = InputView.inputLottoPurchaseAmount();
            return purchaseAmount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmountRecursion();
        }
    }
}
