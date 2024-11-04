package lotto.enums;

public enum Rank {
    THREE(3, 5_000, "3개 일치"),
    FOUR(4, 50_000, "4개 일치"),
    FIVE(5, 1_500_000, "5개 일치"),
    FIVE_AND_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    SIX(6, 2_000_000_000, "6개 일치");

    private final int match;
    private final int prize;
    private final String message;

    Rank(int match, int prize, String message) {
        this.match = match;
        this.prize = prize;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getPrize() {
        return prize;
    }
}
