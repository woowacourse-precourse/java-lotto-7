package lotto.domain;

public enum LottoRank {

    FIFTH_PLACE(3,     false,  5_000),
    FOURTH_PLACE(4,    false, 50_000),
    THIRD_PLACE(5,     false, 1_500_000),
    SECOND_PLACE(5,    true,  30_000_000),
    FIRST_PLACE(6,     false, 2_000_000_000);

    private final int matchCount;
    private final int reward;
    private final boolean isRequireBonus;

    LottoRank(int matchCount, boolean isRequireBonus, int reward) {
        this.matchCount = matchCount;
        this.isRequireBonus = isRequireBonus;
        this.reward = reward;
    }

    public static LottoRank getPrizeRank(int matchedCount, boolean isBonusMatched) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.matchCount == matchedCount && rank.isRequireBonus == isBonusMatched) {
                return rank;
            }
        }
        return null;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
