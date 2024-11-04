package lotto.domain;

public enum LottoMatch {
    NONE(6, 2_000_000_000, "미당첨"),
    THREE_MATCH(3, 5_000, "3개 일치"),
    FOUR_MATCH(4, 50_000, "4개 일치"),
    FIVE_MATCH(5, 1_500_000, "5개 일치"),
    FIVE_MATCH_AND_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    SIX_MATCH(6, 2_000_000_000, "6개 일치");


    private final int matchCount;
    private final int prize;
    private final String statements;

    LottoMatch(int matchCount, int prize, String statements) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.statements = statements;
    }

    public static LottoMatch getLottoMatch(int matchCount, boolean bonusMatch) {
        if (matchCount == 6)
            return SIX_MATCH;
        if (matchCount == 5 && bonusMatch)
            return FIVE_MATCH_AND_BONUS;
        if (matchCount == 5)
            return FIVE_MATCH;
        if (matchCount == 4)
            return FOUR_MATCH;
        if (matchCount == 3)
            return THREE_MATCH;
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getStatements() {
        return statements;
    }
}
