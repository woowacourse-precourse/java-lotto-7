package lotto;

public enum LottoPrize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int numberMatchCount;
    private final boolean bonusNumberRequired;
    private final int prize;

    LottoPrize(int numberMatchCount, boolean bonusNumber, int prize) {
        this.numberMatchCount = numberMatchCount;
        this.bonusNumberRequired = bonusNumber;
        this.prize = prize;
    }

    public int getNumberMatchCount() {
        return numberMatchCount;
    }

    public boolean isBonusNumberRequired() {
        return bonusNumberRequired;
    }

    public int getPrize() {
        return prize;
    }
}
