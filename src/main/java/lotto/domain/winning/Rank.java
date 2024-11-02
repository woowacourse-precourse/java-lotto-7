package lotto.domain.winning;

public enum Rank {
    FIRST(2_000_000_000, "6개 일치"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(1_500_000, "5개 일치"),
    FOURTH(50_000, "4개 일치"),
    FIFTH(5_000, "3개 일치"),
    NO_WIN( 0, "");

    private final int prize;
    private final String message;

    Rank(int prize, String message) {
        this.prize = prize;
        this.message = message;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}