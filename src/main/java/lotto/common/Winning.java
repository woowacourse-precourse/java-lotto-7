package lotto.common;

public enum Winning {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    SIX(2000000000),
    FIVE_BONUS(30000000),
    FAIL(0);

    private static final Winning[] WINNING_ARR = Winning.values();
    private final int prize;

    Winning(int prize) {
        this.prize = prize;
    }

    public static Winning of(int count) {
        if (count < 3) {
            return FAIL;
        }

        return WINNING_ARR[count - 3];
    }

    public int getPrize() {
        return prize;
    }
}
