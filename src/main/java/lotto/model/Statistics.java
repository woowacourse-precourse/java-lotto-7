package lotto.model;

public class Statistics {
    public enum MatchLevel {
        THREE(3, 5000),
        FOUR(4, 50000),
        FIVE(5, 1500000),
        FIVE_BONUS(5, 30000000),
        SIX(6, 2000000000);

        private final int matchCount;
        private final int prize;

        MatchLevel(int matchCount, int prize) {
            this.matchCount = matchCount;
            this.prize = prize;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public int getPrize() {
            return prize;
        }

        public static MatchLevel findMatchType(int matchCount, boolean bonusMatch) {
            if (matchCount == 6) return SIX;
            if (matchCount == 5 && bonusMatch) return FIVE_BONUS;
            if (matchCount == 5) return FIVE;
            if (matchCount == 4) return FOUR;
            if (matchCount == 3) return THREE;
            return null;
        }
    }
}
