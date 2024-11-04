package lotto.model;

public enum LotteryRank {
    FIRST(6, false, 2_000_000_000),  // 1등: 6개 번호 일치
    SECOND(5, true, 30_000_000),     // 2등: 5개 번호 + 보너스 번호 일치
    THIRD(5, false, 1_500_000),      // 3등: 5개 번호 일치
    FOURTH(4, false, 50_000),        // 4등: 4개 번호 일치
    FIFTH(3, false, 5_000);      // 5등: 3개 번호 일치

    private final int hitCount;
    private final boolean requiresBonus;
    private final int money;

    LotteryRank(int hitCount, boolean requiresBonus, int money) {
        this.hitCount = hitCount;
        this.requiresBonus = requiresBonus;
        this.money = money;
    }

    public static LotteryRank getRank(int hitCount, boolean bonusMatched) {
        for (LotteryRank rank : values()) {
            if (rank.hitCount == hitCount && (!rank.requiresBonus || bonusMatched)) {
                return rank;
            }
        }
        return null; // 당첨되지 않은 경우
    }

    public int getMoney() {
        return money;
    }
}
