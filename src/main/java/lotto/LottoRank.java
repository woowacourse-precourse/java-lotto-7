package lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000) {
        @Override
        int calculateRevenue() {
            return FIRST.reward * FIRST.match;
        }
    },
    SECOND(5, 30_000_000) {
        @Override
        int calculateRevenue() {
            return SECOND.reward * SECOND.match;
        }
    },
    THIRD(5, 1_500_000) {
        @Override
        int calculateRevenue() {
            return THIRD.reward * THIRD.match;
        }
    },
    FOURTH(4, 50_000) {
        @Override
        int calculateRevenue() {
            return FOURTH.reward * FOURTH.match;
        }
    },
    FIFTH(3, 5_000) {
        @Override
        int calculateRevenue() {
            return FIFTH.reward * FIFTH.match;
        }
    };

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
            increaseMatch(LottoRank.SECOND);
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

    abstract int calculateRevenue();
}
