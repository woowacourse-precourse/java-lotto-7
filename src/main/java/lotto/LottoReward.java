package lotto;

public enum LottoReward {
    BOOM(0, false, 0),              // 꽝
    FIFTH(3, false, 5000),          // 5등
    FOURTH(4, false, 50000),        // 4등
    THIRD(5, false, 1500000),       // 3등
    SECOND(5, true, 30000000),      // 2등
    FIRST(6, false, 2000000000);    // 1등

    private final int match;
    private final boolean bonus;
    private final int prize;

    LottoReward(int match, boolean bonus, int prize) {
        this.match = match;
        this.bonus = bonus;
        this.prize = prize;
    }

    public int getMatch() {
        return match;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoReward valueOf(int match, boolean bonus) {
        for (LottoReward reward : LottoReward.values()) {
            if (reward.match == match && (!reward.bonus || (bonus == reward.bonus))) {
                return reward;
            }
        }
        return BOOM;
    }
}
