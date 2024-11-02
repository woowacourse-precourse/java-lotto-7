package lotto.controller;

import lotto.domain.Prize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultController {
    private final int PERCENTAGE = 100;
    private final String ROUNDING_OFF_FORMAT = "%.1f";

    public Map<Prize, Integer> makeWinningStatistic(List<Prize> prizeStatus) {
        Map<Prize, Integer> result = initMap();
        for (Prize prize : prizeStatus) {
            if (prize == Prize.LOSE) {
                continue;
            }
            result.put(prize, result.get(prize) + 1);
        }
        return result;
    }

    private Map<Prize, Integer> initMap() {
        Map<Prize, Integer> result = new HashMap<>();
        for (Prize prize : Prize.values()) {
            if (prize == Prize.LOSE) {
                continue;
            }
            result.put(prize, 0);
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
