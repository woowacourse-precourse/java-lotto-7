package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningCombination {

    private final Lotto winningLotto;
    private final Bonus bonus;

    public WinningCombination(Lotto winningLotto, Bonus bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public Map<Rank, Integer> lottoWinningResult(LottoTicket lottoTicket) {
        Map<Rank, Integer> rankCounts = new HashMap<>();

        for (Lotto lotto : lottoTicket.getLottos()) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();

            boolean hasBonusNumber = lotto.getNumbers().contains(bonus.getNumber());

            Rank rank = Rank.findRank(matchCount, hasBonusNumber);

            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }

        return rankCounts;
    }

    public double calculateProfitRate(Map<Rank, Integer> rankCounts, PurchaseAmount purchaseAmount) {
        int totalPrize = rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();

        int totalSpent = purchaseAmount.calculateLottoCount() * 1000;

        return ((double) totalPrize / totalSpent) * 100;
    }
}
