package lotto.controller;

import lotto.sevice.LottoService;
import lotto.view.InputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        int purchaseCount = InputView.requestPurchaseAmount();
        lottoService.issueLottos(purchaseCount);
    }
}
