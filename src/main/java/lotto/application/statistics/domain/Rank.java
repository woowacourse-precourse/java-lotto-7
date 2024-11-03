package lotto.application.statistics.domain;

import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치") {
        @Override
        public boolean matches(int matchCount, boolean matchBonus) {
            return matchCount == 6;
        }
    },
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치") {
        @Override
        public boolean matches(int matchCount, boolean matchBonus) {
            return matchCount == 5 && matchBonus;
        }
    },
    THIRD(5, 1_500_000, "5개 일치") {
        @Override
        public boolean matches(int matchCount, boolean matchBonus) {
            return matchCount == 5 && !matchBonus;
        }
    },
    FOURTH(4, 50_000, "4개 일치") {
        @Override
        public boolean matches(int matchCount, boolean matchBonus) {
            return matchCount == 4;
        }
    },
    FIFTH(3, 5_000, "3개 일치") {
        @Override
        public boolean matches(int matchCount, boolean matchBonus) {
            return matchCount == 3;
        }
    },
    NONE(0, 0, "미당첨") {
        @Override
        public boolean matches(int matchCount, boolean matchBonus) {
            return matchCount < 3;
        }
    };

    private final int matchCount;
    private final int prize;
    private final String description;

    Rank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public abstract boolean matches(int matchCount, boolean matchBonus);

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        return findMatchedRank(matchCount, matchBonus);
    }

    private static Rank findMatchedRank(int matchCount, boolean matchBonus) {
        return Stream.of(values())
                .filter(rank -> rank.matches(matchCount, matchBonus))
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

}
