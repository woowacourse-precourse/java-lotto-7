package lotto.domain.enums;

public enum LottoRank {
    FIFTH(3, false),
    FOURTH(4, false),
    THIRD(5, false),
    SECOND(5, true),
    FIRST(6, false),
    NONE(0, false);

    private final int matchCount;
    private final boolean matchBonus;

    LottoRank(int matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public static LottoRank fromMatchCount(int matchCount, boolean matchBonus) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return NONE;
    }
}
