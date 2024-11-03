package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void run() {
        final Money money = requestPurchaseMoneyAmount();
        System.out.println(money.getLottoPurchasableCount());
    }

    private static Money requestPurchaseMoneyAmount() {
        try {
            OutputView.printRequestPurchaseMoneyAmount();
            int purchaseMoneyAmount = InputView.readNumber();
            return new Money(purchaseMoneyAmount);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return requestPurchaseMoneyAmount();
        }
    }
}
