package lotto.controller;

import lotto.message.error.ErrorMessage;
import lotto.model.service.LottoService;
import lotto.view.inputview.InputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;

    public LottoController(LottoService lottoService, InputView inputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
    }

    public void run() {
        int purchaseAmount = inputView.requestPurchaseAmount();
    }
}
