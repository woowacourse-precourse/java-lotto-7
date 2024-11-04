package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningStatisticsDto {
    private Map<Rank, Integer> winningStatistics;

    WinningStatisticsDto(Map<Rank, Integer> winningStatistics) {
        this.winningStatistics = initializeMap();
        this.winningStatistics.putAll(winningStatistics);
    }

    private Map<Rank, Integer> initializeMap() {
        Map<Rank, Integer> map = new HashMap<>();
        for (Rank a : Rank.values()) {
            map.put(a, 0); // 모든 Enum 값에 대해 0으로 초기화
        }
        return map;
    }

    public Map<Rank, Integer> getWinningStatistics() {
        return new HashMap<>(winningStatistics);
    }

    public double getLottoYield(int purchaseAmount) {
        long totalPrize = winningStatistics.entrySet().stream()
            .mapToLong(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
            .sum();

        return ((double) totalPrize / purchaseAmount) * 100;
    }
}
