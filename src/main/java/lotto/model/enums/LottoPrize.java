package lotto.model.enums;

public enum LottoPrize {
    NONE_PRIZE(-1,  0, 0),
    SECOND_PRIZE(-1, 30000000, 2),
    FIRST_PRIZE(6,  2000000000, 1),
    THIRD_PRIZE(5,  1500000, 3),
    FOURTH_PRIZE(4,  50000, 4),
    FIFTH_PRIZE(3,  5000, 5);

    private final int flagCount;
    private final int prize;
    private final int nstPrize;

    LottoPrize(int flagCount, int prize, int nstPrize) {
        this.flagCount = flagCount;
        this.prize = prize;
        this.nstPrize = nstPrize;
    }

    public int getFlagCount() {
        return flagCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getNstPrize() {
        return nstPrize;
    }
}
