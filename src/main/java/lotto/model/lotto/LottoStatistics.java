package lotto.model.lotto;

import java.util.HashMap;
import java.util.Map;
import lotto.model.rank.LottoRank;

public class LottoStatistics {
    private final Map<LottoRank, Integer> rankCounts = new HashMap<>();
    private int totalPrize = 0;

    public LottoStatistics() {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void calculate(lottoCollection lottoCollection, WinningLotto winningLotto) {
        for (Lotto lotto : lottoCollection.getLottos()) {
            LottoRank rank = determineRank(lotto, winningLotto);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
            totalPrize += rank.getPrize();
        }
    }

    private LottoRank determineRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningLotto.getWinningLotto().getNumbers()::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber());

        return LottoRank.getRankByMatchCount(matchCount, bonusMatch);
    }

    public double calculateEarningsRate(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            return 0.0;
        }
        return (totalPrize / (double) purchaseAmount) * 100;
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }
}
