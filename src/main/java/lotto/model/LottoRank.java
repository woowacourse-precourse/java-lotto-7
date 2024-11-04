package lotto.model;

public enum LottoRank {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    NONE(0, false);

    private final int matchCount;
    private final boolean requiresBonus;

    LottoRank(int matchCount, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
    }

    public static LottoRank getRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 5) {
            return bonusMatch ? SECOND : THIRD;
        }
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank.requiresBonus == bonusMatch) {
                return rank;
            }
        }
        return NONE;
    }
}
