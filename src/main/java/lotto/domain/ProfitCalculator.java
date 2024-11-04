package lotto.domain;

import lotto.dto.PurchaseAmount;

public class ProfitCalculator {
    private double returnOnInvestment;

    public double calculateProfit(WinningResult winningResult, PurchaseAmount purchaseAmount) {
        int purchasePrice = purchaseAmount.getPurchasePrice();
        returnOnInvestment = (double) winningResult.calculateProfit() / purchasePrice * 100;
        return returnOnInvestment;
    }
}
