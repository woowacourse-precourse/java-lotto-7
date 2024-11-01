package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoPurchasedInfo {

    private final List<Lotto> purchased;
    private final Long totalCost;

    private Map<LottoRank, Integer> countResult;

    public LottoPurchasedInfo(List<Lotto> purchased, Long totalCost) {
        this.purchased = purchased;
        this.totalCost = totalCost;
    }

    public Map<LottoRank, Integer> getWinningResult(List<Integer> winningNumber, Integer bonusNumber) {
        if (this.countResult == null) {
            countResult = groupByLottoRank(winningNumber, bonusNumber);
        }
        return Collections.unmodifiableMap(countResult);
    }

    private Map<LottoRank, Integer> groupByLottoRank(List<Integer> winningNumber, Integer bonusNumber) {
        Map<LottoRank, Integer> countResult = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : purchased) {
            int sameNumberCount = lotto.countSameNumber(winningNumber);
            boolean isSecondRank = lotto.isSecondRank(winningNumber, bonusNumber);
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

    public Double calculateProfitPercentage() {
        return calculateTotalRewards() * 100.0 / totalCost;
    }
}
