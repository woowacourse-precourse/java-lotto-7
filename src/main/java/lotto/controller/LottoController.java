package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {
        int purchaseAmount = InputView.purchaseAmount();
        int purchaseCount = lottoService.getPurchaseCount(purchaseAmount);
        OutputView.purchaseCount(purchaseCount);
    }
}
