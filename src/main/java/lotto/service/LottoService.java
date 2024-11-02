package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class LottoService {

    public Map<LottoRank, Integer> calculateLottoStats(List<Lotto> lottoTickets, Lotto winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> lottoStats = initializeStats();

        for (Lotto lottoTicket : lottoTickets) {
            LottoRank rank = getLottoRank(lottoTicket, winningNumbers, bonusNumber);
            lottoStats.put(rank, lottoStats.get(rank) + 1);
        }
        return lottoStats;
    }

    public long calculateTotalWinningAmount(Map<LottoRank, Integer> lottoStats) {
        long totalWinningAmount = 0;

        for (LottoRank rank : lottoStats.keySet()) {
            int prize = rank.getPrizeAmount();
            int count = lottoStats.getOrDefault(rank, 0);
            totalWinningAmount += (long) prize * count;
        }
        return totalWinningAmount;
    }

    public double calculateProfitRate(long totalWinningAmount, int totalPurchaseAmount) {
        return Math.round((double) totalWinningAmount / totalPurchaseAmount * 1000) / 10.0;
    }

    private LottoRank getLottoRank(Lotto lottoTicket, Lotto winningNumbers, int bonusNumber) {
        int matchNumberCount = lottoTicket.countMatchNumber(winningNumbers);
        boolean isMatchBonusNumber = lottoTicket.containsNumber(bonusNumber);
        return LottoRank.findRank(matchNumberCount, isMatchBonusNumber);
    }

    private Map<LottoRank, Integer> initializeStats() {
        Map<LottoRank, Integer> lottoStats = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : LottoRank.values()) {
            lottoStats.put(rank, 0);
        }
        return lottoStats;
    }
}
