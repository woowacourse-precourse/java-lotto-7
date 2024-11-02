package lotto.domain;

public enum Ranking {

    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean isBonusMatched;
    private final int winningPrize;

    Ranking(final int matchCount, final boolean isBonusMatched, final int winningPrize) {
        this.matchCount = matchCount;
        this.isBonusMatched = isBonusMatched;
        this.winningPrize = winningPrize;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean getIsBonusMatched() {
        return this.isBonusMatched;
    }

    public int getWinningPrize() {
        return this.winningPrize;
    }

    public static Ranking getRanking(final int matchCount, final boolean isBonusMatched) {
        for (Ranking ranking : values()) {
            if (ranking.getMatchCount() == matchCount && ranking.getIsBonusMatched() == isBonusMatched) {
                return ranking;
            }
        }
        return null;
    }
}
