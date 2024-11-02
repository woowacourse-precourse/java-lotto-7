package lotto.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.FirstRankLotto;
import lotto.model.Lotto;
import lotto.model.constant.LottoRank;

public class LottoStatisticsService {

    private final LottoRankingService lottoRankingService;

    public LottoStatisticsService() {
        lottoRankingService = new LottoRankingService();
    }

    public Map<LottoRank, Integer> getStatistics(List<Lotto> lottos, FirstRankLotto firstRankLotto) {
        Map<LottoRank, Integer> statistics = new HashMap<>();

        for (Lotto lotto : lottos) {
            addRank(statistics, lottoRankingService.getRank(lotto, firstRankLotto));
        }

        return statistics;
    }

    public void addRank(Map<LottoRank, Integer> statistics, LottoRank rank) {
        statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
    }
}
