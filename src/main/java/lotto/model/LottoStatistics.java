package lotto.model;

import lotto.enums.Rank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<Rank, Integer> resultMap;

    public LottoStatistics() {
        this.resultMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public void calculateStatistics(List<Lotto> lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers.getNumbers());
            boolean matchBonus = lotto.matchingBonusNumber(winningNumbers.getBonusNumber());
            Rank rank = Rank.determineRank(matchCount, matchBonus);
            resultMap.put(rank, resultMap.get(rank) + 1);
        }
    }

    public double calculateProfit(int purchaseAmount) {
        int totalPrize = resultMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }
}
