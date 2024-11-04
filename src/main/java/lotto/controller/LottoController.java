package lotto.controller;

import lotto.util.PurchaseValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        try {
            OutputView.printPurchaseAmountMsg();
            int purchaseAmount = InputView.getPurchaseAmount();
            PurchaseValidator.validatePurchase(purchaseAmount);

            int lottosCount = purchaseAmount / 1000;
            OutputView.printLottoCount(lottosCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}