package lotto;

public enum Rank {
    THREE(3, false, 5000, "3개 일치 (5,000원)"),
    FOUR(4, false, 50000, "4개 일치 (50,000원)"),
    FIVE(5, false, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_BONUS(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(6, false, 2000000000, "6개 일치 (2,000,000,000원)"),
    MISS(0, false, 0, "");  // 메시지를 빈 문자열로 설정

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;
    private final String message;

    Rank(int matchCount, boolean bonusMatch, int prize, String message) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
        this.message = message;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }

    public static Rank of(int matchCount, boolean bonusMatch) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.bonusMatch == bonusMatch) {
                return rank;
            }
        }
        return MISS;
    }
}