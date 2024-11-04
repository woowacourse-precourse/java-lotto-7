package lotto.controller;

import java.util.List;
import lotto.model.Amount;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Ranking;
import lotto.service.LottoService;
import lotto.service.RankingService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final RankingService rankingService;

    public LottoController(LottoService lottoService, RankingService rankingService) {
        this.lottoService = lottoService;
        this.rankingService = rankingService;
    }

    public void run() {
        Amount amount = InputView.inputAmount();
        OutputView.printLottoCount(amount.getAmount());

        List<Lotto> lottos = lottoService.buyLotto(amount.getAmount());
        OutputView.printLottoNumbers(lottos);

        Lotto winningLotto = InputView.inputWinningLotto();

        Bonus bonus = InputView.inputBonusNumber(winningLotto);

        rankingService.evaluateAllLottoResults(lottos, winningLotto, bonus.getNumber());

        OutputView.printWinningStatisticsMessage(Ranking.calculateYield(amount.getAmount()));
    }
}
