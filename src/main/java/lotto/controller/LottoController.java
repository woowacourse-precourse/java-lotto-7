package lotto.controller;

import lotto.domain.LottoManager;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final LottoManager lottoManager;

    public LottoController(InputView inputView, LottoManager lottoManager) {
        this.inputView = inputView;
        this.lottoManager = lottoManager;
    }

    public void run() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        lottoManager.generateLottoNumbers(purchaseAmount);
    }
}
