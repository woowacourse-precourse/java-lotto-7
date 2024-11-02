package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.FirstRankLotto;
import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import lotto.model.constant.LottoRank;

public class LottoStatisticsService {

    private final LottoRankingService lottoRankingService;

    public LottoStatisticsService() {
        lottoRankingService = new LottoRankingService();
    }

    public LottoStatistics getStatistics(List<Lotto> lottos, FirstRankLotto firstRankLotto) {
        Map<LottoRank, Integer> matchedByRank = new HashMap<>();

        for (Lotto lotto : lottos) {
            addRank(matchedByRank, lottoRankingService.getRank(lotto, firstRankLotto));
        }

        int winningPrize = getWinningPrize(matchedByRank);
        double percentRateOfReturn = getPercentRateOfReturn(winningPrize, lottos.size() * Lotto.PRICE);

        return new LottoStatistics(matchedByRank, percentRateOfReturn);
    }

    private double getPercentRateOfReturn(int winningPrize, int buyAmount) {
        return (double) winningPrize / buyAmount * 100;
    }

    private int getWinningPrize(Map<LottoRank, Integer> matchedByRank) {
        int winningPrize = 0;

        for (LottoRank lottoRank : matchedByRank.keySet()) {
            winningPrize += lottoRank.getWinningPrize() * matchedByRank.getOrDefault(lottoRank, 0);
        }

        return winningPrize;
    }
    public void addRank(Map<LottoRank, Integer> matchedByRank, LottoRank rank) {
        matchedByRank.put(rank, matchedByRank.getOrDefault(rank, 0) + 1);
    }
}
