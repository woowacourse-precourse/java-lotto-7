package lotto.controller;

import lotto.view.InputView;
import lotto.domain.LottoService;

public class LottoController {
    private final InputView inputView;
    private LottoService lottoService;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        int purchaseAmount = inputView.getInputPurchaseAmount();
    }
}
