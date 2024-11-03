package lotto.model.lotto.prize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.lotto.Lotto;

public class LottoPrizeCalculator {
    public static Double PERCENT = 100.0;
    private final List<Lotto> lottos;
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public LottoPrizeCalculator(List<Lotto> lottos, Lotto winningLotto, Integer bonusNumber) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Double calculateProfitRate(Long purchaseAmount) {
        Long totalPrize = calculateTotalPrize();
        return ((double) totalPrize / purchaseAmount) * PERCENT;
    }

    public Long calculateTotalPrize() {
        Map<LottoPrizeInfo, Integer> prizeCounts = getPrizeCounts();
        return prizeCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
    }

    public Map<LottoPrizeInfo, Integer> getPrizeCounts() {
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
