package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class LottoService {

    public Map<LottoRank, Integer> calculateWinningStatistics(List<Lotto> lottoTickets, Lotto winningLotto, int bonusNumber) {
        Map<LottoRank, Integer> winningStatistics = initializeStatisticsMap();

        for (Lotto lottoTicket : lottoTickets) {
            LottoRank rank = getLottoRank(lottoTicket, winningLotto, bonusNumber);
            winningStatistics.put(rank, winningStatistics.get(rank) + 1);
        }
        return winningStatistics;
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

    private LottoRank getLottoRank(Lotto lottoTicket, Lotto winningLotto, int bonusNumber) {
        int matchNumberCount = lottoTicket.countMatchNumber(winningLotto);
        boolean isMatchBonusNumber = lottoTicket.containsNumber(bonusNumber);
        return LottoRank.findRank(matchNumberCount, isMatchBonusNumber);
    }

    private Map<LottoRank, Integer> initializeStatisticsMap() {
        Map<LottoRank, Integer> winningStatistics = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : LottoRank.values()) {
            winningStatistics.put(rank, 0);
        }
        return winningStatistics;
    }
}
