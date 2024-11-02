package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == 6;
        }
    },
    SECOND(5, 30_000_000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == 5 && bonusMatch;
        }
    },
    THIRD(5, 1_500_000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == 5 && !bonusMatch;
        }
    },
    FOURTH(4, 50_000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == 4;
        }
    },
    FIFTH(3, 5_000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == 3;
        }
    },
    MISS(0, 0) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount < 3;
        }
    };

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public abstract boolean isMatch(int matchCount, boolean bonusMatch);

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(matchCount, bonusMatch))
                .findFirst()
                .orElse(MISS);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

}
