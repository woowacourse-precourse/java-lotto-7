package lotto.constant;

public enum RankConstant {
    FIRSTRANK(2_000_000_000),
    SECONDRANK(30_000_000),
    THIRDRANK(1_500_000),
    FOURTHRANK(50_000),
    FIFTHRANK(5_000);

    private final int amount;

    RankConstant(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
