package lotto.domain.lotto;

import java.math.BigInteger;
import java.util.Map;
import lotto.domain.Investment;
import lotto.domain.Rank;

public class LottoResult {
    private final Map<Rank, Integer> rankCount;
    private BigInteger totalPrize;

    public LottoResult(Map<Rank, Integer> rankCount, BigInteger totalPrize) {
        this.rankCount = rankCount;
        this.totalPrize = totalPrize;
    }

    public void calculate(LottoBundle lottoBundle, WinningNumbers winningNumbers) {
        initializeRankCount();

        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            Rank rank = winningNumbers.determineRank(lotto);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
            totalPrize = totalPrize.add(rank.getPrize());
        }
    }

    private void initializeRankCount() {
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public double calculateReturnRate(Investment investment) {
        double returnRate = (totalPrize.doubleValue() / investment.getAmount().doubleValue()) * 100;
        return Math.round(returnRate * 10) / 10.0;
    }
}
