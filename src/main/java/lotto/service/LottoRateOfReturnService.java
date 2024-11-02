package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.model.FirstRankLotto;
import lotto.model.Lotto;
import lotto.model.constant.LottoRank;

public class LottoRateOfReturnService {

    private final LottoStatisticsService lottoStatisticsService;

    public LottoRateOfReturnService() {
        this.lottoStatisticsService = new LottoStatisticsService();
    }

    public double getRateOfReturn(List<Lotto> lottos, FirstRankLotto firstRankLotto) {
        Map<LottoRank, Integer> lottoStatistics = lottoStatisticsService.getStatistics(lottos, firstRankLotto);

        int winningPrize = getWinningPrize(lottoStatistics);
        int buyAmount = lottos.size() * Lotto.PRICE;
        return (double) winningPrize / buyAmount;
    }

    private int getWinningPrize(Map<LottoRank, Integer> lottoStatistics) {
        int winningPrize = 0;

        for (LottoRank lottoRank : lottoStatistics.keySet()) {
            winningPrize += lottoRank.getWinningPrize() * lottoStatistics.getOrDefault(lottoRank, 0);
        }

        return winningPrize;
    }
}
