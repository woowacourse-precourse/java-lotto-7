package domain.prize;

public enum Prize {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    NONE(0, 0, 0);

    private final int matchingCount;
    private final int bonusMatch; // 1: 보너스 번호 일치, 0: 불일치
    private final long prizeMoney;

    Prize(int matchingCount, int bonusMatch, long prizeMoney) {
        this.matchingCount = matchingCount;
        this.bonusMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getBonusMatch() {
        return bonusMatch;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize determinePrize(int matchingCount, boolean bonusMatch) {
        for (Prize prize : Prize.values()) {
            if (prize.matchingCount == matchingCount) {
                if (prize.bonusMatch == 1 && bonusMatch) {
                    return prize;
                } else if (prize.bonusMatch == 0 && !bonusMatch) {
                    return prize;
                }
            }
        }
        return NONE;
    }
}