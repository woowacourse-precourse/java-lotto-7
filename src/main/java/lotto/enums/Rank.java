package lotto.enums;

public enum Rank {
    THREE(3, 5000, "3개 일치"),
    FOUR(4, 50000, "4개 일치"),
    FIVE_AND_BONUS(5, 1500000 ,"5개 일치, 보너스 볼 일치"),
    FIVE(5, 30000000, "5개 일치"),
    SIX(6, 2000000000, "6개 일치"),
    ;

    private final int match;
    private final int prize;
    private final String message;

    Rank(int match, int prize, String message) {
        this.match = match;
        this.prize = prize;
        this.message = message;
    }

    public int getPrize() {
        return prize;
    }
}
