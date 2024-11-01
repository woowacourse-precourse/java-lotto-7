package lotto.controller;

import lotto.domain.Prize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultController {

    public Map<Prize, Integer> makeWinningStatistic(List<Prize> prizeStatus) {
        Map<Prize, Integer> result = new HashMap<>();
        for (Prize prize : prizeStatus) {
            if (prize == Prize.LOSE) {
                continue;
            }
            result.put(prize, result.getOrDefault(prize, 0) + 1);
        }
        return result;
    }
}
