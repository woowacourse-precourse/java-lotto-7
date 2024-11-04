package lotto.service;

import lotto.domain.Prize;

import java.util.Map;

public class RateOfReturn {
    private long totalPrize;

    public RateOfReturn(Map<Prize, Integer> resultCounts) {
        for(Prize prize : Prize.values()) {
            addReturn((long)prize.getReward() * resultCounts.get(prize));
        }
    }

    public void addReturn(long prize) {
        totalPrize += prize;
    }

    public double calculateRateOfReturn(int paid) {
        return ((double)totalPrize / paid) * 100;
    }
}
