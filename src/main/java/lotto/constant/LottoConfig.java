package lotto.constant;

import java.util.Arrays;

public class LottoConfig {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_COUNT = 6;

    public enum BonusCheck {
        TRUE, FALSE, ALL;
    }

    public enum Rank {
        NOTHING(0, BonusCheck.ALL, 0L),
        FIFTH(3, BonusCheck.ALL, 5_000L),
        FOURTH(4, BonusCheck.ALL, 50_000L),
        THIRD(5, BonusCheck.FALSE, 1_500_000L),
        SECOND(5, BonusCheck.TRUE, 30_000_000L),
        FIRST(6, BonusCheck.ALL, 2_000_000_000L);

        private final int matchedCount;
        private final BonusCheck isBonusMatched;
        private final long prizeMoney;

        Rank(int matchedCount, BonusCheck isBonusMatched, long prizeMoney) {
            this.matchedCount = matchedCount;
            this.isBonusMatched = isBonusMatched;
            this.prizeMoney = prizeMoney;
        }

        public long calculatePrizeMoney(int count) {
            return count * prizeMoney;
        }

        public int getMatchedCount() {
            return matchedCount;
        }

        public BonusCheck isBonusMatched() {
            return isBonusMatched;
        }

        public long getPrizeMoney() {
            return prizeMoney;
        }

        public static Rank matchRank(int matchCount, BonusCheck bonusCheck) {
            return Arrays.stream(Rank.values())
                    .filter(rank -> findMatchedRank(matchCount, bonusCheck, rank))
                    .findFirst()
                    .orElse(NOTHING);
        }

        private static boolean findMatchedRank(int matchedCount, BonusCheck bonusCheck, Rank rank) {
            return rank.matchedCount == matchedCount &&
                    (rank.isBonusMatched == BonusCheck.ALL || rank.isBonusMatched == bonusCheck);
        }
    }
}
