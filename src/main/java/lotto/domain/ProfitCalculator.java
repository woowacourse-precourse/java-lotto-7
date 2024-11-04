package lotto.domain;

import lotto.dto.PurchaseAmount;

public class ProfitCalculator {
    private double returnOnInvestment;

    public double calculateProfit(WinningResult winningResult, PurchaseAmount purchaseAmount) {
        int purchasePrice = purchaseAmount.getPurchasePrice();
        returnOnInvestment = ((winningResult.calculateProfit() - purchasePrice) * 100.0 / purchasePrice);
        return returnOnInvestment;
    }
}
