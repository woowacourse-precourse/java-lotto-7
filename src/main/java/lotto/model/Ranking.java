package lotto.model;

public enum Ranking {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int numberOfMatch;
    private final boolean requiresBonusMatch;
    private final int prizeMoney;

    Ranking(int numberOfMatch, boolean requiresBonusMatch, int prizeMoney) {
        this.numberOfMatch = numberOfMatch;
        this.requiresBonusMatch = requiresBonusMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Ranking findByMatchAndBonus(int numberOfMatch, boolean isBonusMatch) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.numberOfMatch == numberOfMatch && (!ranking.requiresBonusMatch || isBonusMatch)) {
                return ranking;
            }
        }
        return NONE;
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public boolean requiresBonusMatch() {
        return requiresBonusMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
