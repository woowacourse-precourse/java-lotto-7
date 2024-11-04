package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        generateLottos(purchaseAmount);
    }



    private PurchaseAmount readPurchaseAmount() {
        outputView.promptPurchaseAmount();
        int purchaseAmountInput = inputView.readPurchaseAmountInput();

        return new PurchaseAmount(purchaseAmountInput);
    }

    private void generateLottos(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.calculatePurchasableLottoCount();
        outputView.printPurchasableLottoCount(lottoCount);
        lottoService.generateLottos(lottoCount);
    }
}
