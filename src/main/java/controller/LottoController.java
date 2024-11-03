package controller;

import model.lotto.Lotto;
import model.lotto.Lottos;
import model.money.Money;
import model.result.EarningsRate;
import model.result.RankResult;
import service.LottoService;
import service.ResultService;
import view.InputView;
import view.OutputView;

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
