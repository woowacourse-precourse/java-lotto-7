package lotto;

public enum LottoPrize {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_WITH_BONUS(5, 30000000), // 보너스 번호가 맞았을 때
    SIX(6, 2000000000);

    private final int matchCount;
    private final long prizeMoney;

    LottoPrize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    // 정수 값과 보너스 여부를 받아서 상금을 반환하는 메서드
    public static long getPrize(int matchCount, boolean bonus) {
        if (matchCount == 5 && bonus) {
            return FIVE_WITH_BONUS.prizeMoney; // 보너스 번호가 맞았을 때 상금
        }

        for (LottoPrize prize : values()) {
            if (prize.matchCount == matchCount) {
                return prize.prizeMoney; // 해당하는 상금 반환
            }
        }
        return 0;
    }
}
