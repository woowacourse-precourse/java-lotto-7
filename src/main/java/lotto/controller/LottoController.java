package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.money.Money;
import lotto.model.result.EarningsRate;
import lotto.model.result.RankResult;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final ResultService resultService;

    public LottoController(final InputView inputView, final OutputView outputView, final LottoService lottoService, final ResultService resultService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.resultService = resultService;
    }

    public void run() {
        Money purchaseAmount = inputView.readPurchaseAmount();
        int lottoCount = purchaseAmount.calculateLottoCount();

        Lottos lottos = lottoService.generate(lottoCount);
        outputView.displayLottos(lottos, lottoCount);

        Lotto winningLotto = inputView.readWinningNumber();
        Integer bonus = inputView.readBonus(winningLotto);

        RankResult result = resultService.getRankResult(lottos, winningLotto, bonus);
        EarningsRate earningsRate = resultService.getEarningsRate(result, purchaseAmount);
        outputView.displayResult(result, earningsRate);
    }
}
