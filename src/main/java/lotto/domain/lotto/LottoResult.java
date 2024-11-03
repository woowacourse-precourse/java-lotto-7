package lotto.domain.lotto;

import java.math.BigInteger;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCount;
    private BigInteger totalPrize;

    public LottoResult(Map<Rank, Integer> rankCount, BigInteger totalPrize) {
        this.rankCount = rankCount;
        this.totalPrize = totalPrize;
    }

    public void calculate(LottoBundle lottoBundle, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        initializeRankCount();

        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            Rank rank = determineRank(lotto, winningNumbers, bonusNumber);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
            totalPrize = totalPrize.add(rank.getPrize());
        }
    }

    private Rank determineRank(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int matchCount = winningNumbers.calculateMatchCount(lotto);
        boolean hasBonusNumber = matchCount == 5 && bonusNumber.hasMatchingBonusNumber(lotto);
        return Rank.of(matchCount, hasBonusNumber);
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
