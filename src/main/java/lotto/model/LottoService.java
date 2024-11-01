package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    public Map<LottoRank, Integer> calculateWinningStatistics(List<Lotto> userLottos, Lotto winningLotto, int bonusNumber) {
        Map<LottoRank, Integer> statistics = initializeStatisticsMap();

        for (Lotto userLotto : userLottos) {
            LottoRank rank = determineLottoRank(winningLotto, bonusNumber, userLotto);
            statistics.put(rank, statistics.get(rank) + 1);
        }
        return statistics;
    }

    public long calculateTotalWinnings(Map<LottoRank, Integer> statistics) {
        long totalWinnings = 0;

        for (LottoRank rank : statistics.keySet()) {
            int prize = rank.getPrizeAmount();
            int count = statistics.getOrDefault(rank, 0);
            totalWinnings += (long) prize * count;
        }

        return totalWinnings;
    }

    public double calculateProfitRate(long totalWinnings, int totalPurchaseAmount) {
        return Math.round((double) totalWinnings / totalPurchaseAmount * 1000) / 10.0;
    }

    private LottoRank determineLottoRank(Lotto winningLotto, int bonusNumber, Lotto userLotto) {
        int matchNumberCount = userLotto.getMatchNumberCount(winningLotto);
        boolean isMatchBonusNumber = userLotto.containsNumber(bonusNumber);
        return LottoRank.findRank(matchNumberCount, isMatchBonusNumber);
    }

    private Map<LottoRank, Integer> initializeStatisticsMap() {
        Map<LottoRank, Integer> statistics = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            statistics.put(rank, 0);
        }
        return statistics;
    }
}
