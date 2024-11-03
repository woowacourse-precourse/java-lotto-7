package lotto.domain;

import java.util.Arrays;

public enum Rank {
    SIX_MATCHES("6개 일치", 2_000_000_000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == 6;
        }
    },
    FIVE_MATCHES_WITH_BONUS("5개 일치, 보너스 볼 일치", 30_000_000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == 5 && bonusMatch;
        }
    },
    FIVE_MATCHES("5개 일치", 1_500_000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == 5 && !bonusMatch;
        }
    },
    FOUR_MATCHES("4개 일치", 50_000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == 4;
        }
    },
    THREE_MATCHES("3개 일치", 5_000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == 3;
        }
    },
    NO_MATCH(null, 0) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount < 3;
        }
    };

    private final String matchCount;
    private final int prize;

    Rank(String matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public abstract boolean isMatch(int matchCount, boolean bonusMatch);

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(matchCount, bonusMatch))
                .findFirst()
                .orElse(NO_MATCH);
    }

    public String getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

}
