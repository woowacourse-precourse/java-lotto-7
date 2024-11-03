package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.service.LottoService;
import lotto.service.StatsService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final StatsService statsService;

    public LottoController(LottoService lottoService, StatsService statsService) {
        this.lottoService = lottoService;
        this.statsService = statsService;
    }

    public void start() {
        int purchaseAmount = InputView.purchaseAmount();
        int purchaseCount = lottoService.getPurchaseCount(purchaseAmount);
        OutputView.purchaseCount(purchaseCount);

        List<Lotto> lottos = lottoService.makeLottos(purchaseCount);
        OutputView.lottoNumbers(lottos);

        Lotto winningLotto = InputView.winningLotto();
        int bonusNumber = InputView.bonusNumber(winningLotto.getNumbers());

        Player player = new Player(winningLotto, bonusNumber);
        statsService.calculateStats(lottos, player);
    }
}
