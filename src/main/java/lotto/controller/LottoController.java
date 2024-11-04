package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();
        lottoService.purchaseLottos(purchaseAmount);
        OutputView.printLottos(lottoService.getPurchasedLottos());

        WinningLotto winningLotto = InputView.getWinningLotto();
        LottoResult result = lottoService.calculateResult(winningLotto);
        OutputView.printResult(result);
    }

}
