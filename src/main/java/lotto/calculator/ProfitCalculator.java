package lotto.calculator;

import lotto.application.Calculator;

public class ProfitCalculator implements Calculator {

    @Override
    public double calculateProfit(int totalPrize, int purchasePrice) {
        double result = ((double) (totalPrize - purchasePrice) / purchasePrice) * 100;
        if (result < 0) {
            return 100 + result;
        }
        return result;
    }
}
