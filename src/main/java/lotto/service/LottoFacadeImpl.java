package lotto.service;

import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;
import lotto.service.issuing.LottoIssuingService;
import lotto.service.winningStatistic.WinningStatisticService;

public class LottoFacadeImpl implements LottoFacade {
    private final LottoIssuingService lottoIssuingService;

    private final WinningStatisticService winningStatisticService;

    public LottoFacadeImpl(LottoIssuingService lottoIssuingService, WinningStatisticService winningStatisticService) {
        this.lottoIssuingService = lottoIssuingService;
        this.winningStatisticService = winningStatisticService;
    }

    @Override
    public Lottos issueLottos(int purchaseAmount) {
        return lottoIssuingService.issueLottos(purchaseAmount);
    }

    @Override
    public WinningStatistic getStatistic(int cost, Lottos lottos, WinningNumbers winningNumbers) {
        return winningStatisticService.calculateWinningStatistic(cost, lottos, winningNumbers);
    }
}
