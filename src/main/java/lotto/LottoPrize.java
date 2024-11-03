package lotto;

public enum LottoPrize {

    FIRST_PRIZE(6, false, 2_000_000_000),
    SECOND_PRIZE(5, true, 30_000_000),
    THIRD_PRIZE(5, false, 1_500_000),
    FOURTH_PRIZE(4, false, 50_000),
    FIFTH_PRIZE(3, false, 5_000);

    private final int winningCount;
    private final boolean bonusExists;
    private final int prize;

    LottoPrize(int winningCount, boolean bonusExists, int prize) {
        this.winningCount = winningCount;
        this.bonusExists = bonusExists;
        this.prize = prize;
    }
}
