package lotto.domain.lotto;

import java.math.BigInteger;
import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Investment;
import lotto.domain.Rank;

public class LottoResult {
    private final Map<Rank, Integer> rankCount;
    private final BigInteger totalPrize;

    private LottoResult(Map<Rank, Integer> rankCount, BigInteger totalPrize) {
        this.rankCount = rankCount;
        this.totalPrize = totalPrize;
    }

    public static LottoResult calculate(LottoBundle lottoBundle, WinningNumbers winningNumbers) {
        Map<Rank, Integer> rankCount = initializeRankCount();
        BigInteger totalPrize = BigInteger.ZERO;

        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            Rank rank = winningNumbers.determineRank(lotto);
            rankCount.put(rank, rankCount.get(rank) + 1);
            totalPrize = totalPrize.add(rank.getPrize());
        }

        return new LottoResult(rankCount, totalPrize);
    }

    private static Map<Rank, Integer> initializeRankCount() {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
        return rankCount;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public double calculateReturnRate(Investment investment) {
        return totalPrize.doubleValue() / investment.getAmount().doubleValue() * 100;
    }
}
