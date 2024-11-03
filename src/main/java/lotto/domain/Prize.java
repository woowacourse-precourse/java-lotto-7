package lotto.domain;

import java.util.Arrays;

public enum Prize {
    // 각 등수에 해당하는 일치 개수와 상금 정의
    THREE(3, 5_000),                // 3개 일치
    FOUR(4, 50_000),                // 4개 일치
    FIVE(5, 1_500_000),             // 5개 일치
    FIVE_BONUS(5, 30_000_000),       // 5개 + 보너스 볼 일치
    SIX(6, 2_000_000_000),          // 6개 일치
    NONE(0, 0);                     // 일치하지 않음

    private final int matchCount;
    private final int reward;

    Prize(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Prize valueOf(int matchCount, boolean bonusNumberIncluded) {
        if (matchCount == 5 && bonusNumberIncluded) {
            return FIVE_BONUS;
        }

        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(Prize.NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
