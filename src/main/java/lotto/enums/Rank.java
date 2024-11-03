package lotto.enums;

public enum Rank {
    ZERO(0, false, 0, " "),
    ONE(6, false, 2000000000, "6개 일치 (2,000,000,000원)"),
    TWO(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THREE(5, false, 1500000, "5개 일치 (1,500,000원)"),
    FOUR(4, false, 50000, "4개 일치 (50,000원)"),
    FIVE(3, false, 5000, "3개 일치 (5,000원)"),
    ;

    private final int matchCount;
    private final boolean isBonusMatch;
    private final int reword;
    private final String message;

    Rank(int matchCount, boolean isBonusMatch, int reword, String message) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.reword = reword;
        this.message = message;
    }

    public static Rank getRankByResult(int matchCount, boolean isBonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && rank.isBonusMatch == isBonusMatch) {
                return rank;
            }
        }
        return ZERO;
    }

    public int getReword() {
        return reword;
    }

    public String getMessage() {
        return message;
    }
}
