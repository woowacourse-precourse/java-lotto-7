package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoRankEvaluator {
    //TODO 수익금 계산
    private final Map<Rank, Integer> rankCount;
    private final long rateOfReturn;

    private final static int CHECK_BONUS_CRITERIA = 5;

    public LottoRankEvaluator(Map<Rank, Integer> rankCount, long rateOfReturn) {
        this.rankCount = rankCount;
        this.rateOfReturn = rateOfReturn;
    }

    public Map<Rank,Integer> evaluator(List<Lotto> lottos, List<Integer> winnerNumbers, int bonusNumber) {
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

    private Rank evaluateRank(List<Integer> winnerNumbers, Lotto lotto, int bonusNumber) {
         int matchCount =  Math.toIntExact(lotto.getNumbers().stream().filter(winnerNumbers::contains).count());
         boolean isBonusMatch = lotto.getNumbers().contains(bonusNumber);

         return Rank.findByAttributes(matchCount,isBonusMatch);
    }
}
