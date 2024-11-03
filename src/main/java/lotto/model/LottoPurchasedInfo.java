package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoPurchasedInfo {

    private final List<Lotto> purchased;
    private final Long totalCost;

    private Map<LottoRank, Long> winningCountByRank;

    public LottoPurchasedInfo(List<Lotto> purchased, Long totalCost) {
        this.purchased = purchased;
        this.totalCost = totalCost;
    }

    public Map<LottoRank, Long> getWinningResult(List<Integer> winningNumber, Integer bonusNumber) {
        if (this.winningCountByRank == null) {
            winningCountByRank = groupByLottoRank(winningNumber, bonusNumber);
        }
        return Collections.unmodifiableMap(winningCountByRank);
    }

    private Map<LottoRank, Long> groupByLottoRank(List<Integer> winningNumber, Integer bonusNumber) {
        Map<LottoRank, Long> countResult = new EnumMap<>(LottoRank.class);

        purchased.forEach(lotto -> {
            LottoRank lottoRank = lotto.checkRank(winningNumber, bonusNumber);
            countResult.merge(lottoRank, 1L, Long::sum);
        });

        return Collections.unmodifiableMap(countResult);
    }

    public Long calculateTotalProfit() {
        return Arrays.stream(LottoRank.values())
                .map(rank -> {
                    Long winningCount = winningCountByRank.getOrDefault(rank, 0L);
                    return rank.calculateProfitByCount(winningCount);
                })
                .reduce(0L, Long::sum);
    }

    public Double calculateProfitPercentage() {
        return this.calculateTotalProfit() * 100.0 / totalCost;
    }
}
