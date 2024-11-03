package lotto.domain;

public enum Ranking {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5,1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchingCount;
    private final int prize;

    Ranking(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Ranking getRanking(int matchingCount, boolean hasBonus) {
        if (SECOND.getMatchingCount() == matchingCount && hasBonus) {
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

    public int getPrize() {
        return prize;
    }
}
