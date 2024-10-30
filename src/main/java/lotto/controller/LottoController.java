package lotto.controller;

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
        double purchaseAmount = readPurchaseAmount();
        this.lottoService = new LottoService(purchaseAmount);
    }

    private double readPurchaseAmount() {
        outputView.printReadPurchaseAmount();
        return inputView.readPurchaseAmount();
    }
}
