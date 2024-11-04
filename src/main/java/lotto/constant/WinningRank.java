package lotto.constant;

public enum WinningRank {
    ZERO(0, 0, ""),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private static final int MINIMUM_WINNING = 3;
    private static final int SECOND_WINNING_COUNT = 5;
    private int count;
    private int prize;
    private String message;

    WinningRank(int count, int prize, String message) {
        this.count = count;
        this.prize = prize;
        this.message = message;
    }

    public static WinningRank getRank(int count, boolean bonus) {
        if (count < MINIMUM_WINNING) {
            return ZERO;
        }

        if (count == SECOND_WINNING_COUNT && bonus) {
            return SECOND;
        }

        for (WinningRank winningRank : values()) {
            if (count == winningRank.count) {
                return winningRank;
            }
        }

        return ZERO;
    }

    public String getMessage() {
        return message;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }
}
