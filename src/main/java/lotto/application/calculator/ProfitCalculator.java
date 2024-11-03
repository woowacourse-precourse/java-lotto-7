package lotto.application.calculator;

import lotto.application.Calculator;

public class ProfitCalculator implements Calculator {

    @Override
    public double calculateProfit(int totalPrize, int purchasePrice) {
        return ((double) totalPrize / purchasePrice) * 100;
    }
}
