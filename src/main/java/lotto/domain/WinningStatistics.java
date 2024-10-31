package lotto.domain;

import static lotto.domain.Rank.EMPTY;
import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.EnumMap;
import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Integer> statistics;

    private WinningStatistics(Map<Rank, Integer> statistics) {
        this.statistics = statistics;
    }

    public static WinningStatistics init() {
        Map<Rank, Integer> enumMap = new EnumMap<>(Map.of(
                FIRST, 0,
                SECOND, 0,
                THIRD, 0,
                FOURTH, 0,
                FIFTH, 0,
                EMPTY, 0
        ));
        return new WinningStatistics(enumMap);
    }

    public void saveWinningResult(Rank rank) {
        statistics.put(rank, statistics.get(rank) + 1);
    }

    public Integer getRankCount(Rank rank) {
        return statistics.get(rank);
    }

    public double calculateRateOfReturn(int purchaseAmount) {
        Long winningPrice = statistics.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        return winningPrice / (double) purchaseAmount * 100;
    }
}
