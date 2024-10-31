package lotto.entity;

public class LottoYieldCalculator {
    private final long totalInvestment;
    private long totalPrize;

    public LottoYieldCalculator(long totalInvestment) {
        this.totalInvestment = totalInvestment;
    }

    public void addPrize(long prize) {
        totalPrize += prize;
    }

    public double calculateYield() {
        if (totalInvestment == 0) return 0.0;
        return Math.round((double) totalPrize / totalInvestment * 10000) / 100.0;
    }
}