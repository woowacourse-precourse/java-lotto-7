package lotto.service;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoWinningNumbers;

public class LottoResultAnalyzer {

    private Map<LottoPrize, Integer> rankCount = new EnumMap<>(LottoPrize.class);

    public LottoResultAnalyzer() {
        for (LottoPrize value : LottoPrize.values()) {
            rankCount.put(value, 0);
        }
    }

    public Map<LottoPrize, Integer> analyze(Lotto[] userLotto, LottoWinningNumbers winningLotto){
        List<Long> sameNumberPerLotto = countSameNumberPerLotto(userLotto, winningLotto);
        for (Long count : sameNumberPerLotto) {
            determineRank(count);
        }

        return rankCount;
    }

    private List<Long> countSameNumberPerLotto(Lotto[] userLotto, LottoWinningNumbers winningLotto){
         return Arrays.stream(userLotto)
                 .map(o -> o.compareResult(winningLotto))
                 .toList();
    }

    private void determineRank(Long count) {
        for (LottoPrize value : LottoPrize.values()) {
            if (count == value.getMatchNumber()) {
                rankCount.put(value, rankCount.get(value) + 1);
            }
        }
    }

    public int get(LottoPrize prize){
        return rankCount.get(prize);
    }

    public double computeYield(LottoGenerator generator){
        int result = 0;
        for (LottoPrize prize : rankCount.keySet()) {
            result += prize.getPrize() * rankCount.get(prize);
        }

        return ((double) result / generator.getPurchaseAmount()) * 100;
    }
}
