package lotto.constant;

public class LottoConfig {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_COUNT = 6;

    public enum BonusCheck {
        TRUE, FALSE, ALL;
    }

    public enum Rank {
        FIRST(6, BonusCheck.ALL, 2_000_000_000),
        SECOND(5, BonusCheck.TRUE, 30_000_000),
        THIRD(5, BonusCheck.FALSE, 1_500_000),
        FOURTH(4, BonusCheck.ALL, 50_000),
        FIFTH(3, BonusCheck.ALL, 5_000),
        NOTHING(0, BonusCheck.ALL, 0);

        private final int matchedCount;
        private final BonusCheck isBonusMatched;
        private final int prizeMoney;

        Rank(int matchedCount, BonusCheck isBonusMatched, int prizeMoney) {
            this.matchedCount = matchedCount;
            this.isBonusMatched = isBonusMatched;
            this.prizeMoney = prizeMoney;
        }

        public int getMatchedCount() {
            return matchedCount;
        }

        public BonusCheck isBonusMatched() {
            return isBonusMatched;
        }

        public int getPrizeMoney() {
            return prizeMoney;
        }
    }
}
