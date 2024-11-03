package lotto.model;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private static final int MIN_MATCH_COUNT_FOR_RANKING = 3;
    private static final int MATCH_COUNT_FOR_SECOND = 5;

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    LottoRank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount < MIN_MATCH_COUNT_FOR_RANKING) {
            return NONE;
        }
        if (matchCount == MATCH_COUNT_FOR_SECOND && matchBonus) {
            return SECOND;
        }
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return NONE;
    }
}