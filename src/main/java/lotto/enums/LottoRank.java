package lotto.enums;

public enum LottoRank {
    THREE_MATCHES(3, false, 5000),
    FOUR_MATCHES(4, false, 50000),
    FIVE_MATCHES(5, false, 1500000),
    FIVE_MATCHES_WITH_BONUS_NUMBER(5, true, 30000000),
    SIX_MATCHES(6, false, 2000000000);

    private final int matchCount;
    private final boolean requiresBonusMatch;
    private final int prize;

    LottoRank(int matchCount, boolean requiresBonusMatch, int prize) {
        this.matchCount = matchCount;
        this.requiresBonusMatch = requiresBonusMatch;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage(int count) {
        if (this == FIVE_MATCHES_WITH_BONUS_NUMBER) {
            return "5개 일치, 보너스 볼 일치 (" + prize + "원) - " + count + "개";
        }
        return matchCount + "개 일치 (" + prize + "원) - " + count + "개";
    }

    public static LottoRank findByMatchCountAndBonus(int matchCount, boolean requiresBonusMatch) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank.requiresBonusMatch == requiresBonusMatch) {
                return rank;
            }
        }
        return null;
    }
}
