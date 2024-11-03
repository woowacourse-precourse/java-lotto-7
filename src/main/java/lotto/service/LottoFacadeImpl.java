package lotto.service;

import java.util.List;
import lotto.model.Lottos;
import lotto.model.WinningStatistic;
import lotto.service.issuing.LottoIssuingService;
import lotto.service.statistic.StatisticService;

public class LottoFacadeImpl implements LottoFacade {
    private final LottoIssuingService lottoIssuingService;
    private final StatisticService statisticService;

    public LottoFacadeImpl(LottoIssuingService lottoIssuingService, StatisticService statisticService) {
        this.lottoIssuingService = lottoIssuingService;
        this.statisticService = statisticService;
    }

    @Override
    public Lottos issueLottos(int purchaseAmount) {
        return lottoIssuingService.issueLottos(purchaseAmount);
    }

    @Override
    public WinningStatistic getStatistic(int purchaseAmount, int cost, List<Integer> winningNumbers, int bonusNumber,
                                         Lottos lottos) {
        return statisticService.getStatistic(purchaseAmount, cost, winningNumbers, bonusNumber, lottos);
    }
}
