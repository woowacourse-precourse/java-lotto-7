package lotto.model;

public class Statistics {
    public enum MatchLevel {
        THREE(3, 5000),
        FOUR(4, 50000),
        FIVE(5, 1500000),
        FIVE_BONUS(5, 30000000),
        SIX(6, 2000000000);

        private final int matchCount; // 일치 수
        private final int prize; // 상금

        // 생성자
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

        // 매치 타입을 찾는 메서드
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
