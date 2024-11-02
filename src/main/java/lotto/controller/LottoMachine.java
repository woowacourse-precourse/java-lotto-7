package lotto.controller;

import lotto.common.Parser;
import lotto.model.PurchaseAmount;
import lotto.view.InputView;

public class LottoMachine {
    private InputView inputView;

    public LottoMachine(InputView inputView) {
        this.inputView = inputView;
    }

    public void lottery() {
        PurchaseAmount purchaseAmount = initializePurchaseAmount();
    }

    private PurchaseAmount initializePurchaseAmount() {
        final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

        try {
            String rawAmount = inputView.readLine(PURCHASE_AMOUNT_MESSAGE);
            long amount = Parser.stringToLong(rawAmount);

            return new PurchaseAmount(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initializePurchaseAmount();
        }
    }
}
