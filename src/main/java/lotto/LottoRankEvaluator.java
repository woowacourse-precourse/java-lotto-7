package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoRankEvaluator {
    private final Map<Rank, Integer> rankCount;
    private final double rateOfReturn;
    private final static int LOTTO_PRICE = 1000;

    public LottoRankEvaluator(List<Lotto> lottos, List<Integer> winnerNumbers, int bonusNumber) {
        this.rankCount = evaluator(lottos, winnerNumbers, bonusNumber);
        this.rateOfReturn = calculateRateOfReturn(lottos.size() * LOTTO_PRICE);
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    private Map<Rank,Integer> evaluator(List<Lotto> lottos, List<Integer> winnerNumbers, int bonusNumber) {
        Map<Rank,Integer> rankCount = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = evaluateRank(winnerNumbers,lotto,bonusNumber);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        return rankCount;
    }

    private double calculateRateOfReturn(int totalPurchase) {
        int totalWinningPrize = 0;
        for (Map.Entry<Rank, Integer> entry : rankCount.entrySet()) {
            Rank rank = entry.getKey();
            totalWinningPrize += rank.getWinningPrice() * entry.getValue();
        }

        BigDecimal result = BigDecimal.valueOf(totalWinningPrize / totalPurchase);
        BigDecimal roundResult = result.setScale(2, RoundingMode.HALF_UP);
        return roundResult.doubleValue();
    }

    private Rank evaluateRank(List<Integer> winnerNumbers, Lotto lotto, int bonusNumber) {
         int matchCount =  Math.toIntExact(lotto.getNumbers().stream().filter(winnerNumbers::contains).count());
         boolean isBonusMatch = lotto.getNumbers().contains(bonusNumber);

         return Rank.findByAttributes(matchCount,isBonusMatch);
    }
}
