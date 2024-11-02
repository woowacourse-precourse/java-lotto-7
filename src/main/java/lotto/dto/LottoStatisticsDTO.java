package lotto.dto;

public class LottoStatisticsDTO {
    private final int purchaseAmount;
    private final int totalPrizeAmount;
    private final double profitRate;

    public LottoStatisticsDTO(int purchaseAmount, int totalPrizeAmount, double profitRate) {
        this.purchaseAmount = purchaseAmount;
        this.totalPrizeAmount = totalPrizeAmount;
        this.profitRate = profitRate;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getTotalPrizeAmount() {
        return totalPrizeAmount;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
