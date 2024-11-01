package lotto.model.lotto;

public enum Rank {
    FIRST_PLACE(2_000_000_000, 6, false, "6개 일치 (2,000,000,000원)"),

    SECOND_PLACE(3_000_000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)"),

    THIRD_PLACE(1_500_000, 5, false, "5개 일치 (1,500,000원)"),

    FOURTH_PLACE(50_000, 4, false, "4개 일치 (50,000원)"),

    FIFTH_PLACE(5_000, 3, false, "3개 일치 (5,000원)"),

    OUT_OF_RANK(0, 0, false, null);

    private final int prizeMoney;
    private final int matchingCount;
    private final boolean requiresBonusMatch;
    private final String description;

    Rank(int prizeMoney, int matchingCount, boolean requiresBonusMatch, String description) {
        this.prizeMoney = prizeMoney;
        this.matchingCount = matchingCount;
        this.requiresBonusMatch = requiresBonusMatch;
        this.description = description;
    }

    public static Rank findRank(int matchingCount, boolean bonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.matchingCount == matchingCount &&
                    (matchingCount != 5 || rank.requiresBonusMatch == bonusMatch)) {
                return rank;
            }
        }
        return OUT_OF_RANK;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}
