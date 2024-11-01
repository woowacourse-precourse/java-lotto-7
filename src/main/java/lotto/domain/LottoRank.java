package lotto.domain;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private static final int SECOND_PRIZE_MATCH_COUNT = 5;
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

    public int getMatchCount() {
        return matchCount;
    }

    public static LottoRank findByMatchCountAndBonus(int count, boolean matchBonus) {
        if (isSecondPrize(count, matchBonus)) {
            return SECOND;
        }
        return findMatchingRank(count);
    }

    private static boolean isSecondPrize(int count, boolean matchBonus) {
        return count == SECOND_PRIZE_MATCH_COUNT && matchBonus;
    }

    private static LottoRank findMatchingRank(int count) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == count && !rank.matchBonus) {
                return rank;
            }
        }
        return MISS;
    }
}
