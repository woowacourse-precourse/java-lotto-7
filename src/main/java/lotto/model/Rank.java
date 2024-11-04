package lotto.model;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;      // 일치하는 번호 개수
    private final boolean requiresBonus; // 보너스 번호 일치 필요 여부
    private final int prize;           // 상금

    Rank(int matchCount, boolean requiresBonus, int prize) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.requiresBonus == bonusMatch) {
                return rank;
            }
        }
        return NONE;
    }
}
