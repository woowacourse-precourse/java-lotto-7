package lotto.model;

import java.util.EnumMap;
import lotto.util.Grade;

public class ProfitCalculator extends Calculator {
    public Double calculateProfit(final EnumMap<Grade, Integer> gradeWithCounts, final int expenditure) {
        return divide(calculateTotalRevenue(gradeWithCounts), expenditure);
    }

    private Integer calculateTotalRevenue(final EnumMap<Grade, Integer> gradeWithCounts) {
        return gradeWithCounts.entrySet().stream()
                .map(gradeWithCount -> gradeWithCount.getKey().getPrizeMoney() * gradeWithCount.getValue())
                .mapToInt(i -> i)
                .sum();
    }
}
