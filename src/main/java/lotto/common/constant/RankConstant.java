package lotto.common.constant;

public enum RankConstant {
    FIRSTRANK(2_000_000_000, 6),
    SECONDRANK(30_000_000, 10),
    THIRDRANK(1_500_000, 5),
    FOURTHRANK(50_000, 4),
    FIFTHRANK(5_000, 3);

    private final int amount;
    private final int matching;

    RankConstant(int amount, int matching) {
        this.amount = amount;
        this.matching = matching;
    }

    public int getAmount() {
        return amount;
    }

    public int getMatching() {
        return matching;
    }
}
