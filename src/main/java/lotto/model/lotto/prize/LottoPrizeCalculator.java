package lotto.model.lotto.prize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.lotto.Lotto;

public class LottoPrizeCalculator {
    private final Map<LottoPrizeInfo, Integer> prizeCounts = new HashMap<>();

    public Long calculateTotalPrice(List<Lotto> lottos, Lotto winningLotto, Integer bonusNumber) {
        Map<LottoPrizeInfo, Integer> prizeCounts = countPrize(lottos, winningLotto, bonusNumber);

        return prizeCounts.entrySet().parallelStream()
                .mapToLong(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
    }

    private Map<LottoPrizeInfo, Integer> countPrize(List<Lotto> lottos, Lotto winningLotto, Integer bonusNumber) {
        Map<LottoPrizeInfo, Integer> prizeCounts = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningLotto);
            boolean hasBonus = lotto.hasBonus(bonusNumber);

            LottoPrizeInfo prizeInfo = LottoPrizeInfo.getPrizeByMatch(matchCount, hasBonus);
            prizeCounts.put(prizeInfo, prizeCounts.getOrDefault(prizeInfo, 0) + 1);
        }

        return prizeCounts;
    }
}
