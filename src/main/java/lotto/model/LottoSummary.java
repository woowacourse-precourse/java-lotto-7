package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoSummary {

    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;
    private final Map<LottoRank, Integer> countResult;

    public LottoSummary(List<Integer> numbers, Integer bonusNumber) {
        this.winningNumbers = numbers;
        this.bonusNumber = bonusNumber;
        this.countResult = new EnumMap<>(LottoRank.class);
    }

    public Map<LottoRank, Integer> countByLottoRank(List<Lotto> purchased) {
        for (Lotto lotto : purchased) {
            int sameNumberCount = lotto.countSameNumber(winningNumbers);
            LottoRank rank = LottoRank.findRank(sameNumberCount, lotto.isSecondRank(sameNumberCount, bonusNumber));
            countResult.merge(rank, 1, Integer::sum);
        }
        return countResult;
    }

    public Long calculateTotalRewards() {
        return LottoRank.getLottoRanks().stream()
                .map(rank -> rank.getReward()*countResult.getOrDefault(rank, 0))
                .reduce(0L, Long::sum);
    }

    public Double calculateProfitPercentage(Integer totalCost) {
        Long totalReward = calculateTotalRewards();
        return totalReward * 100.0 / totalCost;
    }
}
