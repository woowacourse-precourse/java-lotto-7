package lotto.domain;

import lotto.dto.PurchaseAmount;

public class ProfitCalculator {
    private double returnOnInvestment;

    public double calculateProfit(WinningResult winningResult, PurchaseAmount purchaseAmount) {
        int purchasePrice = purchaseAmount.getPurchasePrice();
        returnOnInvestment = (double) winningResult.calculateProfit() * 100 / purchasePrice;
        return returnOnInvestment;
    }
}
