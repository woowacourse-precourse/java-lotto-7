package lotto.common;

public enum Winning {
    FAIL(0, 0),
    THREE(5000, 3),
    FOUR(50000, 4),
    FIVE(1500000, 5),
    SIX(2000000000, 6),
    FIVE_BONUS(30000000, 7);

    private static final Winning[] WINNING_ARR = Winning.values();
    private final int winnings;
    private final int count;

    Winning(int winnings, int count) {
        this.winnings = winnings;
        this.count = count;
    }

    public static Winning of(int count) {
        if (count < 3) {
            return FAIL;
        }

        return WINNING_ARR[count - 2];
    }

    public int getWinnings() {
        return winnings;
    }
}
