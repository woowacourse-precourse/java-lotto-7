package lotto;

// 로또 등수와 상금을 정의하는 Enum

public enum Rank {
    FIRST(6, false, 2_000_000_000),     // 번호 6개 일치
    SECOND(5, true, 30_000_000),        // 번호 5개, 보너스번호 일치
    THIRD(5, false, 1_500_000),         // 번호 5개 일치
    FOURTH(4, false, 50_000),           // 번호 4개 일치
    FIFTH(3, false, 5_000),             // 번호 3개 일치
    BOMB(0, false, 0);                  // 나머지는 낙첨! 꽝!

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prize;

    Rank(int matchCount, boolean requiresBonus, int prize) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
    }

    // Getter 메소드
    public int getPrize() {
        return prize;
    }

    // 일치 개수와 보너스 여부에 따른 등수 반환
    public static Rank findRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatch) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return BOMB;
    }
}
