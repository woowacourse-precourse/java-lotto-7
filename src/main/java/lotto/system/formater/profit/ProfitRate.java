package lotto.system.formater.profit;

public class ProfitRate {

    private final double profitRate;

    public ProfitRate(double profitRate) {
        validateProfitRate(profitRate);
        this.profitRate = profitRate;
    }

    private void validateProfitRate(double profitRate) {
        if (profitRate < 0) {
            throw new IllegalArgumentException("수익률은 0보다 작을 수 없습니다.");
        }
    }

    public double getProfitRate() {
        return profitRate;
    }

    @Override
    public String toString() {
        return String.format("%.2f%%", profitRate);
    }
}