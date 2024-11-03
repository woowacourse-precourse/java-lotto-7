package lotto.controller;

import lotto.input.PurchaseAmountProcessor;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        int purchaseAmount = setPurchaseAmount();
        outputView.printLottoCount(purchaseAmount);
    }

    private int setPurchaseAmount(){
        String purchaseAmount = inputView.getPurchaseAmount();
        return PurchaseAmountProcessor.calculatePurchaseCount(purchaseAmount);
    }

}
