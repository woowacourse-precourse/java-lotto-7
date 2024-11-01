package lotto.controller;

import lotto.model.LottoAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoAmount lottoAmount = purchaseLottos();
    }

    private LottoAmount purchaseLottos() {
        try {
            String purchaseAmount = inputView.inputPurchaseAmount();
            return new LottoAmount(purchaseAmount);
        } catch (IllegalArgumentException e) {
            outputView.outputExceptionMessage(e.getMessage());
            return purchaseLottos();
        }
    }
}
