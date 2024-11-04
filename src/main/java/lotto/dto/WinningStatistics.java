package lotto.dto;

import java.util.Map;
import lotto.model.WinningType;

public record WinningStatistics(Map<WinningType, Integer> statistics) {
    private static final int DEFAULT_VALUE = 0;

    public int getWinningCount(WinningType type) {
        return statistics.getOrDefault(type, DEFAULT_VALUE);
    }
}
