package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        PurchaseAmount amount = readPurchasePrice();
        System.out.println(amount.getLottoCount());
    }

    private PurchaseAmount readPurchasePrice() {
        outputView.printPurchaseGuid();
        return inputView.readPurchasePrice();
    }
}
