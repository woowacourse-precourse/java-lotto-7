package lotto.global;

import static lotto.global.error.LottoErrorMessages.INVALID_MATCH_COUNT;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank findByMatchCount(int i) {
        if (i == 5) {
            throw new IllegalStateException(INVALID_MATCH_COUNT.toString());
        }

        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchCount() == i) {
                return rank;
            }
        }

        throw new IllegalStateException(INVALID_MATCH_COUNT.toString() + i);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

}
