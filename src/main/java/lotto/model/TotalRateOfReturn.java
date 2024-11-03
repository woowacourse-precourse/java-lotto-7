package lotto.model;

public class TotalRateOfReturn {
    private double totalRateOfReturn;

    public TotalRateOfReturn(int totalPrize, int purchasePrice) {
        calculate(totalPrize, purchasePrice);
    }

    public double get() {
        return totalRateOfReturn;
    }

    private void calculate(int totalPrize, int purchasePrice) {
        totalRateOfReturn = (double) totalPrize / purchasePrice * 100;
    }
}
