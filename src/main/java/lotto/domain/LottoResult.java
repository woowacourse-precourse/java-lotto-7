package lotto.domain;

import lotto.constants.Ranking;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private static final double PERCENTAGE_UNIT = 100.0;

    private final EnumMap<Ranking, Integer> rankingMap;

    private LottoResult(EnumMap<Ranking, Integer> rankingMap) {
        this.rankingMap = rankingMap;
    }

    public static LottoResult from(List<Ranking> rankings) {
        EnumMap<Ranking, Integer> rankingMap = rankings.stream()
                .collect(Collectors.groupingBy(r -> r, () -> new EnumMap<>(Ranking.class), Collectors.summingInt(r -> 1)));
        return new LottoResult(rankingMap);
    }

    public double calculateProfit(int money) {
        long totalReward = rankingMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
        double profit = (double) totalReward / money * PERCENTAGE_UNIT;
        return Math.round(profit * PERCENTAGE_UNIT) / PERCENTAGE_UNIT;
    }

    public Map<Ranking, Integer> getRankingMap() {
        return rankingMap;
    }
}
