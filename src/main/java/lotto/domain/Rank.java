package lotto.domain;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
    FAIL(0, false, 0, "");

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;
    private final String matchMessage;

    private Rank(int matchCount, boolean bonusMatch, int prize, String matchMessage) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
        this.matchMessage = matchMessage;
    }

    public int getPrize() {
        return prize;
    }

    public String getMatchMessage() {
        return matchMessage;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.bonusMatch == bonusMatch) {
                return rank;
            }
        }
        return FAIL;
    }

}
