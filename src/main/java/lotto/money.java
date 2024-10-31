package lotto;

public enum money {
        FIRST(6, false, 2000000000),        // 1등: 6개 번호 일치 2,000,000,000원
        SECOND(5, true, 30000000),            // 2등: 5개 번호 + 보너스 번호 일치 30,000,000원
        THIRD(5, false, 1500000),             // 3등: 5개 번호 일치 1,500,000원
        FOURTH(4, false, 50000),               // 4등: 4개 번호 일치 50,000원
        FIFTH(3, false, 5000),                 // 5등: 3개 번호 일치 5,000원
        NONE(0, false, 0);                      // 등수 없음: 상금 0원

        private final int matchCount;           // 일치하는 번호 수
        private final boolean bonusMatch;       // 보너스 번호 일치 여부
        private final int prize;                // 상금

        // 생성자
        money(int matchCount, boolean bonusMatch, int prize) {
            this.matchCount = matchCount;
            this.bonusMatch = bonusMatch;
            this.prize = prize;
        }

        // 일치하는 번호 수를 반환하는 메서드
        public int getMatchCount() {
            return matchCount;
        }

        // 보너스 번호 일치 여부를 반환하는 메서드
        public boolean isBonusMatch() {
            return bonusMatch;
        }

        // 상금을 반환하는 메서드
        public int getPrize() {
            return prize;
        }

        // 특정 일치 개수와 보너스 번호 여부에 따라 등수를 반환하는 정적 메서드
        public static money valueOf(int matchCount, boolean bonusMatch) {
            for (money money : values()) {
                if (money.matchCount == matchCount && money.bonusMatch == bonusMatch) {
                    return money;
                }
            }
            return NONE; // 해당하는 등수가 없으면 NONE 반환
        }
}
