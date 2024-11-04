package lotto.model;

public enum LottoRank {
    FIFTH(3, false, 5_000, "3개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    NONE(0, false, 0, "");

    private static final int MIN_MATCH_COUNT_FOR_RANKING = 3;
    private static final int MATCH_COUNT_FOR_SECOND = 5;

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;
    private final String description;

    LottoRank(
            int matchCount,
            boolean matchBonus,
            int prize,
            String description
    ) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.description = description;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static LottoRank valueOf(
            int matchCount,
            boolean matchBonus
    ) {
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