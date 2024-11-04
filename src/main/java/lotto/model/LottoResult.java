package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> rankCounts;

    public LottoResult(LottoTickets lottoTickets, WinningNumbers winningNumbers, int bonusNumber) {
        rankCounts = initRankCounts();
        calculateResults(lottoTickets, winningNumbers, bonusNumber);
    }

    private Map<Rank, Integer> initRankCounts() {
        Map<Rank, Integer> counts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            counts.put(rank, 0);
        }
        return counts;
    }

    private void calculateResults(LottoTickets lottoTickets, WinningNumbers winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottoTickets.getTickets()) {
            Rank rank = getRank(lotto, winningNumbers, bonusNumber);
            if (rank != Rank.NONE) {
                rankCounts.put(rank, rankCounts.get(rank) + 1);
            }
        }
    }

    private Rank getRank(Lotto lotto, WinningNumbers winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
        return Rank.valueOf(matchCount, bonusMatch);
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }

    public int getTotalWinningAmount() {
        int total = 0;
        for (Rank rank : Rank.values()) {
            total += rank.getWinningMoney() * rankCounts.get(rank);
        }
        return total;
    }
}
