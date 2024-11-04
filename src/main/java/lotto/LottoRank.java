package lotto;

public enum LottoRank {
    NONE(0, false, 0, ""),
    FIFTH(3, false, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prize;
    private final String description;

    LottoRank(int matchCount, boolean requiresBonus, int prize, String description) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
        this.description = description;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return description;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank.requiresBonus == bonusMatch) {
                return rank;
            }
        }
        return NONE;
    }
}
