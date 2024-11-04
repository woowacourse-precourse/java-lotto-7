package lotto.domain;

public enum Ranking {
    FIRST(6, false, 2000000000),    // 1등: 6개 번호 일치
    SECOND(5, true, 30000000),      // 2등: 5개 번호 + 보너스 번호 일치
    THIRD(5, false, 1500000),       // 3등: 5개 번호 일치
    FOURTH(4, false, 50000),        // 4등: 4개 번호 일치
    FIFTH(3, false, 5000);          // 5등: 3개 번호 일치

    private final int matchCount;   // 일치하는 번호 개수
    private final boolean bonus;    // 보너스 번호 여부
    private final int prize;        // 상금

    PrizeRank(int matchCount, boolean bonus, int prize) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getPrize() {
        return prize;
    }

    // 특정 당첨 조건을 기반으로 상금 랭크를 반환하는 메서드
    public static PrizeRank getRank(int matchCount, boolean hasBonus) {
        for (PrizeRank rank : PrizeRank.values()) {
            if (rank.matchCount == matchCount && rank.bonus == hasBonus) {
                return rank;
            }
        }
        return null; // 일치하는 순위가 없는 경우
    }

}
