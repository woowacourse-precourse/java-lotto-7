package lotto.week3.dto;

import java.util.Map;

public class StatisticsRequestDto {

    private final Map<String, Integer> stratistics;

    public StatisticsRequestDto(Map<String, Integer> stratistics) {
        this.stratistics = Map.copyOf(stratistics);
    }

    public Map<String, Integer> getStratistics() {
        return stratistics;
    }
}
