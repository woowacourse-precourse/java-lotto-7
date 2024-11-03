package lotto.domain;

public enum LottoRank {
    THIRD(3, 5000, false),
    FOURTH(4, 50000, false),
    SECOND(5, 1500000, false),
    BONUS_SECOND(5, 30000000, true), // 보너스 볼 일치를 true로 설정
    FIRST(6, 2000000000, false);

    private final int matchCount;
    private final int prize;
    private final boolean bonusMatch;

    LottoRank(int matchCount, int prize, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonusMatch = bonusMatch;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {

        if (bonusMatch) {
            return String.format("%d개 일치, 보너스 볼 일치", matchCount);
        }

        return String.format("%d개 일치", matchCount);
    }

    public static LottoRank calculateRank(int matchCount, boolean bonusMatch) {

        if (matchCount == FIRST.matchCount) return FIRST;
        if (matchCount == BONUS_SECOND.matchCount && bonusMatch) return BONUS_SECOND;
        if (matchCount == SECOND.matchCount && !bonusMatch) return SECOND;
        if (matchCount == FOURTH.matchCount) return FOURTH;
        if (matchCount == THIRD.matchCount) return THIRD;
        return null;  // 등수가 없는 경우

    }
}