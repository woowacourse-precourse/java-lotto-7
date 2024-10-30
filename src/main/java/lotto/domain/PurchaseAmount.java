package lotto.domain;

public class PurchaseAmount {
    private static final int UNIT = 1000;
    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount <= 0 || amount % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public int getTicketCount() {
        return amount / UNIT;
    }

    public double calculateYield(int totalPrize) {
        double yield = (double) totalPrize / amount * 100;
        return Math.round(yield * 10) / 10.0;
    }
}
