package lotto.model;

import java.util.EnumMap;
import lotto.util.Grade;

public class ProfitCalculator extends Calculator {
    public Long calculateProfit(final EnumMap<Grade, Integer> gradeWithCounts, final int expenditure) {
        return divide(calculateTotalRevenue(gradeWithCounts)-expenditure, expenditure);
    }

    private Integer calculateTotalRevenue(final EnumMap<Grade, Integer> gradeWithCounts) {
        return gradeWithCounts.entrySet().stream()
                .map(gradeWithCount -> gradeWithCount.getKey().getPrizeMoney() * gradeWithCount.getValue())
                .peek(System.out::println)
                .mapToInt(i -> i)
                .sum();
    }
}
