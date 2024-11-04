package lotto.controller;

import lotto.domain.Lotto;
import lotto.sevice.LottoService;
import lotto.view.InputView;
import lotto.view.OuputView;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        int purchaseCount = InputView.requestPurchaseAmount();
        List<Lotto> lottos = lottoService.issueLottos(purchaseCount);
        OuputView.printLottos(lottos);
    }
}
