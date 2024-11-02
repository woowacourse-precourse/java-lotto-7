package lotto.model.enums;

public enum LottoPrize {
    SIXTH_PRIZE(-1, null, 0, 0),
    FIRST_PRIZE(6, false, 2000000000, 1),
    SECOND_PRIZE(5, true, 30000000, 2),
    THIRD_PRIZE(5, false, 1500000, 3),
    FOURTH_PRIZE(4, false, 50000, 4),
    FIFTH_PRIZE(3, false, 5000, 5);

    private final int flagCount;
    private final Boolean bonusNumberMatchFlag;
    private final int prize;
    private final int nstPrize;

    LottoPrize(int flagCount, Boolean bonusNumberMatchFlag, int prize, int nstPrize) {
        this.flagCount = flagCount;
        this.bonusNumberMatchFlag = bonusNumberMatchFlag;
        this.prize = prize;
        this.nstPrize = nstPrize;
    }

    public int getFlagCount() {
        return flagCount;
    }

    public Boolean isBonusNumberMatchFlag() {
        return bonusNumberMatchFlag;
    }

    public int getPrize() {
        return prize;
    }

    public int getNstPrize() {
        return nstPrize;
    }
}
