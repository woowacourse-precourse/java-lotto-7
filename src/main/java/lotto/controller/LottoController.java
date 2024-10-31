package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private LottoService lottoService;

    public LottoController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        this.lottoService = new LottoService(purchaseAmount);
        printLottoPurchaseResult(purchaseAmount);
    }

    private void printLottoPurchaseResult(PurchaseAmount purchaseAmount) {
        int numberOfLotto = purchaseAmount.getNumberOfLotto();
        outputView.printLottoPurchaseResult(numberOfLotto);
    }

    private PurchaseAmount readPurchaseAmount() {
        outputView.printReadPurchaseAmount();
        double purchaseAmount = inputView.readPurchaseAmount();
        return new PurchaseAmount(purchaseAmount);
    }
}
