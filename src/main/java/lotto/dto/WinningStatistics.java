package lotto.dto;

import java.util.Map;
import lotto.model.WinningType;

public record WinningStatistics(Map<WinningType, Integer> statistics) {
    public int getWinningCount(WinningType type) {
        return statistics.getOrDefault(type, 0);
    }
}
