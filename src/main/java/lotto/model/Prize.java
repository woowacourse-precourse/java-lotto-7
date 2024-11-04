package lotto.model;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    BOMB(0, false, 0); // 꽝

    private final int correctCount;
    private final boolean checkBonus;
    private final int resultPrize;

    Prize(int correctCount, boolean checkBonus, int resultPrize) {
        this.correctCount = correctCount;
        this.checkBonus = checkBonus;
        this.resultPrize = resultPrize;
    }

    public int getResultPrize() {
        return resultPrize;
    }

    public static Prize valueOf(int isCorrectedCount, boolean isRequiredBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.correctCount == isCorrectedCount && rank.checkBonus == isRequiredBonus)
                .findFirst()
                .orElse(BOMB);
    }
}
