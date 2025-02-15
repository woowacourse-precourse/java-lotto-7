package lotto.dto;

public class LottoStatisticsDTO {
    private final int budget;
    private final int totalPrizeAmount;
    private final double profitRate;

    public LottoStatisticsDTO(int budget, int totalPrizeAmount, double profitRate) {
        this.budget = budget;
        this.totalPrizeAmount = totalPrizeAmount;
        this.profitRate = profitRate;
    }

    public int getBudget() {
        return budget;
    }

    public int getTotalPrizeAmount() {
        return totalPrizeAmount;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
