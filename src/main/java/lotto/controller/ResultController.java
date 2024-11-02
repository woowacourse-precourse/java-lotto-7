package lotto.controller;

import lotto.domain.Prize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultController {
    private final int INITIAL_MATCH_COUNT = 0;
    private final int ONE = 1;
    private final int PERCENTAGE = 100;
    private final String ROUNDING_OFF_FORMAT = "%.1f";

    public Map<Prize, Integer> makeWinningStatistic(List<Prize> prizeStatus) {
        Map<Prize, Integer> result = initMap();
        for (Prize prize : prizeStatus) {
            if (prize == Prize.LOSE) {
                continue;
            }
            result.put(prize, result.get(prize) + ONE);
        }
        return result;
    }

    private Map<Prize, Integer> initMap() {
        Map<Prize, Integer> result = new HashMap<>();
        for (Prize prize : Prize.values()) {
            if (prize == Prize.LOSE) {
                continue;
            }
            result.put(prize, INITIAL_MATCH_COUNT);
        }
        return result;
    }

    public String calculateEarningRatio(Map<Prize, Integer> statistic, int buyingAmount) {
        float sum = 0f;
        for (Prize prize : statistic.keySet()) {
            sum += statistic.get(prize) * prize.getAmount();
        }
        float ratio = sum / buyingAmount * PERCENTAGE;
        return String.format(ROUNDING_OFF_FORMAT, ratio);
    }
}
