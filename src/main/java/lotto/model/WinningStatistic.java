package lotto.model;

import java.util.EnumMap;
import java.util.Map;

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
}