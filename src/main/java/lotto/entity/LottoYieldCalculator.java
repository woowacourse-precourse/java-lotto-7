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
        return totalInvestment == 0 ? 0.0 : calculateYieldPercentage();
    }

    private double calculateYieldPercentage() {
        return Math.round((double) totalPrize / totalInvestment * 10000) / 100.0;
    }

    public void printYield() {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", calculateYield());
    }
}
