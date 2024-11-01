package lotto.domain.winning;

public enum Rank {
    FIRST(6, false, 2000_000_000, "1등: 6개 번호 일치"),
    SECOND(5, true, 30_000_000, "2등: 5개 번호 + 보너스 번호 일치"),
    THIRD(5, false, 1_500_000, "3등: 5개 번호 일치"),
    FOURTH(4, false, 50_000, "4등: 4개 번호 일치"),
    FIFTH(3, false, 5_000, "5등: 3개 번호 일치"),
    NO_WIN(0, false, 0, "꽝: 당첨되지 않았습니다.");

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