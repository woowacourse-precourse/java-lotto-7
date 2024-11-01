package lotto;

public enum LottoPrize {
    FIRST(6, 0),
    SECOND(5, 1),
    THIRD(5, 0),
    FOURTH(4, 0),
    FIFTH(3, 0);

    private int correctWinningNumberCount;
    private int correctBonusNumberCount;

    LottoPrize(int correctWinningNumberCount, int correctBonusNumberCount) {
        this.correctBonusNumberCount = correctBonusNumberCount;
        this.correctWinningNumberCount = correctWinningNumberCount;
    }

    public int getCorrectWinningNumberCount() {
        return correctWinningNumberCount;
    }

    public int getCorrectBonusNumberCount() {
        return correctBonusNumberCount;
    }
}
