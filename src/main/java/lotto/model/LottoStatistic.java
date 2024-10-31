package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistic {

    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;
    private final Map<LottoRank, Integer> countResult;

    public LottoStatistic(List<Integer> numbers, Integer bonusNumber) {
        this.winningNumbers = numbers;
        this.bonusNumber = bonusNumber;
        this.countResult = new EnumMap<>(LottoRank.class);
    }

    public Map<LottoRank, Integer> countByLottoRank(List<Lotto> purchased) {
        for (Lotto lotto : purchased) {
            int sameNumberCount = lotto.countSameNumber(winningNumbers);
            boolean isSecondRank = lotto.isSecondRank(sameNumberCount, bonusNumber);
            LottoRank rank = LottoRank.findRank(sameNumberCount, isSecondRank);

            countResult.merge(rank, 1, Integer::sum);
        }
        return Collections.unmodifiableMap(countResult);
    }

    public Long calculateTotalRewards() {
        return Arrays.stream(LottoRank.values())
                .map(rank -> rank.getReward() * countResult.getOrDefault(rank, 0))
                .reduce(0L, Long::sum);
    }

    public Double calculateProfitPercentage(Long totalProfit, Integer totalCost) {
        return totalProfit * 100.0 / totalCost;
    }
}
