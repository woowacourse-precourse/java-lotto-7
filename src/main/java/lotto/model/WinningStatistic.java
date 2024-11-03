package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class WinningStatistic {
    private static Map<NumberMatchType, Integer> matchCounts;

    private WinningStatistic() {
    }

    public static void createStatistics() {
        WinningStatistic.matchCounts = new EnumMap<>(NumberMatchType.class);
        for (NumberMatchType type : NumberMatchType.values()) {
            matchCounts.put(type, 0);
        }
    }

    public static void incrementMatchCount(NumberMatchType type) {
        if (type != null) {
            matchCounts.put(type, matchCounts.get(type) + 1);
        }
    }

    public static String getWinningStatistics() {
        return Arrays.stream(NumberMatchType.values())
                .map(type -> type.getMessage() + matchCounts.get(type) + "개")
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public static double getRate(int purchaseLottoSize) {
        double totalRevenue = 0.0;
        for (NumberMatchType type : NumberMatchType.values()) {
            totalRevenue += matchCounts.get(type) * type.getPrice();
        }
        return (totalRevenue / (purchaseLottoSize * 1000)) * 100;
    }
}