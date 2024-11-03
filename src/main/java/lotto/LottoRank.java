package lotto;

public enum LottoRank {
    FIFTH(3, false, 5_000, "3개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, false, 2_000_000_000, "6개 일치");

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;
    private final String matchDescription;

    LottoRank(int matchCount, boolean bonusMatch, int prize, String matchDescription) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
        this.matchDescription = matchDescription;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getPrize() {
        return prize;
    }

    public String getMatchDescription() {
        return matchDescription;
    }
}