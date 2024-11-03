package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void run() {
        int purchaseMoneyAmount = requestPurchaseMoney();
    }

    private static int requestPurchaseMoney() {
        try {
            OutputView.printRequestPurchaseMoney();
            int purchaseMoney = InputView.readNumber();
            return purchaseMoney;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return requestPurchaseMoney();
        }
    }
}
