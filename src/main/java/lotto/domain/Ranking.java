package lotto.domain;

public enum Ranking {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchingCount;
    private final boolean requiresBonus;
    private final int prize;

    Ranking(int matchingCount, boolean requiresBonus, int prize) {
        this.matchingCount = matchingCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
    }

    public static Ranking getRanking(int matchingCount, boolean hasBonus) {
        if (SECOND.getMatchingCount() == matchingCount && SECOND.isRequiresBonus() == hasBonus) {
                return SECOND;
        }
        for (Ranking ranking : values()) {
            if (ranking.matchingCount == matchingCount && ranking != SECOND) {
                return ranking;
            }
        }

        return NONE;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isRequiresBonus() {
        return requiresBonus;
    }

    public int getPrize() {
        return prize;
    }
}
