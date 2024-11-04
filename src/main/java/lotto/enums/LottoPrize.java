package lotto.enums;

import java.util.Arrays;

// 등수 별 맞춘 갯수, 상금을 관리하는 열거 클래스
public enum LottoPrize {
    NO_PRIZE(0, false, 0),
    FIFTH_PRIZE(3, false, 5_000),
    FOURTH_PRIZE(4, false, 50_000),
    THIRD_PRIZE(5, false, 1_500_000),
    SECOND_PRIZE(5, true, 30_000_000),
    FIRST_PRIZE(6, false, 2_000_000_000);

    private final int correctCount;
    private final boolean bonus;
    private final int prizeMoney;

    private LottoPrize(int correctCount, boolean bonus, int prizeMoney) {
        this.correctCount = correctCount;
        this.prizeMoney = prizeMoney;
        this.bonus = bonus;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoPrize getFromCorrectCountAndBonus(int correctCount, boolean bonus) {
        if (correctCount == 5) {
            return Arrays.stream(LottoPrize.values())
                    .filter(prize -> prize.correctCount == correctCount)
                    .filter(prize -> prize.bonus == bonus)
                    .findFirst()
                    .get();
        }

        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.correctCount == correctCount)
                .findFirst()
                .get();
    }
}