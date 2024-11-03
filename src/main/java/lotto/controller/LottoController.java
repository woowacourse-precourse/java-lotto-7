package lotto.controller;

import lotto.converter.StringToIntegerConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public LottoController() {
    }

    public void start() {
        int purchaseAmount = getPurchaseAmountInput();
    }

    private int getPurchaseAmountInput() {
        OutputView.printPurchaseAmountInputMessage();
        String purchaseAmount = InputView.inputPurchaseAmount();
        return StringToIntegerConverter.convert(purchaseAmount);

    }
}
