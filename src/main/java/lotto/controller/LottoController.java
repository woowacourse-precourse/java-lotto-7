package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void startLotto() {
        String purchaseAmount = InputView.getLottoPurchaseAmount();
        lottoService.validatePurchaseAmount(purchaseAmount);
    }

}
