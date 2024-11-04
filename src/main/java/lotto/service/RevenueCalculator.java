package lotto.service;

import java.util.List;
import lotto.model.Rank;

public class RevenueCalculator {
    public double calculate(List<Rank> ranks, Integer count) {
        long total = 0L;
        for (Rank rank : ranks) {
            total += rank.calculate(1);
        }
        return Math.round((total / (double)count * 100) * 10)/10.0;
    }
}
