package lotto.domain.winning;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NO_WIN(0, false, 0, "");

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize; // 상금
    private final String message;

    Rank(int matchCount, boolean hasBonus, int prize, String message) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}