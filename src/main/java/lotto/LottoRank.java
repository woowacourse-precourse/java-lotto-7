package lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int matchCount;
    private final int reward;
    private int match;

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.match = 0;
    }

    public int getMatch() {
        return match;
    }

    public void resetMatch() {
        match = 0;
    }

    public static LottoRank matchRank(int matchCount, boolean isMatchedBonus) {
        if (matchCount == 5 && isMatchedBonus) {
            LottoRank.SECOND.match++;
            return LottoRank.SECOND;
        }

        LottoRank rank = Arrays.stream(LottoRank.values())
                .filter(value -> value != LottoRank.SECOND)
                .filter(value -> value.matchCount == matchCount)
                .findFirst()
                .orElseThrow();

        increaseMatch(rank);

        return rank;
    }

    private static void increaseMatch(LottoRank rank) {
        rank.match++;
    }
}
