package lotto.model.service;

import java.util.Arrays;

public enum LottoPrize {
    FIFTH(5000, 3, false),
    FOURTH(50000, 4, false),
    THIRD(1500000, 5, false),
    SECOND(30000000, 5, true),
    FIRST(2000000000, 6, false);

    private final int prize;
    private int correctCount;
    private boolean isBonusCorrect;

    LottoPrize(int prize, int correctCount, boolean isBonusCorrect) {
        this.prize = prize;
        this.correctCount = correctCount;
        this.isBonusCorrect = isBonusCorrect;
    }

    public int getPrize() {
        return prize;
    }

    public String getCommaPrize() {
        return String.format("%,d", prize) + "원";
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public boolean isBonusCorrect() {
        return isBonusCorrect;
    }

    public static LottoPrize findBy(int correctCount, boolean isBonusCorrect) {
        if (correctCount == 5) {
            if (isBonusCorrect) {
                return LottoPrize.SECOND;
            }
            return LottoPrize.THIRD;
            
        }

        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.correctCount == correctCount)
                .findFirst()
                .orElse(null);
    }


}
