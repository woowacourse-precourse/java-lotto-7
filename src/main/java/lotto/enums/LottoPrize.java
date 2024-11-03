package lotto.enums;

public enum LottoPrize {
    THREE_WINNING_PRIZE(5000),
    FOUR_WINNING_PRIZE(50000),
    FIVE_WINNING_PRIZE(1500000),
    FIVE_WINNING_WITH_BONUS_PRIZE(30000000),
    SIX_WINNING_PRIZE(2000000000);

    private final int prize;
    LottoPrize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
