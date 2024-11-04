package lotto.system.formater.profit;

public record ProfitRate(double profitRate) {

    public ProfitRate {
        validateProfitRate(profitRate);
    }

    private void validateProfitRate(double profitRate) {
        if (profitRate < 0) {
            throw new IllegalArgumentException("수익률은 0보다 작을 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return String.format("%.2f%%", profitRate);
    }
}