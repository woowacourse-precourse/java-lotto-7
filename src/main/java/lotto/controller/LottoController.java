package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.domain.strategy.RandomNumberGenerationStrategy;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final LottoService lottoService;
    private final InputHandler inputHandler;

    public LottoController(OutputView outputView,
                           LottoService lottoService,
                           InputHandler inputHandler) {
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.inputHandler = inputHandler;
    }

    public void process() {
        Money lottoPurchaseMoney = inputHandler.inputLottoPurchaseMoney();
        Lottos purchasedLottos = lottoService.purchaseLottos(lottoPurchaseMoney, new RandomNumberGenerationStrategy());
        outputView.printPurchaseLottos(purchasedLottos.getLottos());

        WinningLotto winningLotto = inputHandler.inputWinningLotto();
        LottoResult lottoResult = lottoService.calculateLottoResult(purchasedLottos, winningLotto);
        outputView.printLottoResults(lottoResult);
    }
}
