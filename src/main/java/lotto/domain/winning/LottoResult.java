package lotto.domain.winning;

import java.math.BigInteger;
import java.util.Map;
import lotto.domain.lotto.Investment;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBundle;

public class LottoResult {

    private static final int DEFAULT_VALUE = 0;
    private static final int SUM_AMOUNT = 1;
    private static final int SECOND_PRIZE_MATCH_COUNT = 5;

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
            rankCount.put(rank, rankCount.getOrDefault(rank, DEFAULT_VALUE) + SUM_AMOUNT);
            totalPrize = totalPrize.add(rank.getPrize());
        }
    }

    private Rank determineRank(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int matchCount = winningNumbers.calculateMatchCount(lotto);
        boolean hasBonusNumber = matchCount == SECOND_PRIZE_MATCH_COUNT && bonusNumber.hasMatchingBonusNumber(lotto);
        return Rank.of(matchCount, hasBonusNumber);
    }

    private void initializeRankCount() {
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, DEFAULT_VALUE);
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
