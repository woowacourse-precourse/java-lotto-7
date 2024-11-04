package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {

    private final IteratorInputHandler iteratorInputHandler;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(IteratorInputHandler iteratorInputHandler,
                           OutputView outputView,
                           LottoService lottoService) {
        this.iteratorInputHandler = iteratorInputHandler;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void process() {
        Money lottoPurchaseMoney = iteratorInputHandler.inputLottoPurchaseMoney();
        Lottos purchasedLottos = lottoService.purchaseLottos(lottoPurchaseMoney);
        outputView.printPurchaseLottos(purchasedLottos.getLottos());

        WinningLotto winningLotto = iteratorInputHandler.inputWinningLotto();
        LottoResult lottoResult = lottoService.calculateLottoResult(purchasedLottos, winningLotto);
        outputView.printLottoResults(lottoResult);
    }
}
