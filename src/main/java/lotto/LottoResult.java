package lotto;

public class LottoResult {
    private static final int FIRST_PRIZE = 2_000_000_000;
    private static final int SECOND_PRIZE = 30_000_000;
    private static final int THIRD_PRIZE = 1_500_000;
    private static final int FOURTH_PRIZE = 50_000;
    private static final int FIFTH_PRIZE = 5_000;

    private final int threeMatchesCount;
    private final int fourMatchesCount;
    private final int fiveMatchesCount;
    private final int fiveMatchesWithBonusCount;
    private final int sixMatchesCount;

    public LottoResult(int threeMatchesCount, int fourMatchesCount, int fiveMatchesCount, int fiveMatchesWithBonusCount,
                       int sixMatchesCount) {
        this.threeMatchesCount = threeMatchesCount;
        this.fourMatchesCount = fourMatchesCount;
        this.fiveMatchesCount = fiveMatchesCount;
        this.fiveMatchesWithBonusCount = fiveMatchesWithBonusCount;
        this.sixMatchesCount = sixMatchesCount;
    }

    public int getThreeMatchesCount() {
        return threeMatchesCount;
    }

    public int getFourMatchesCount() {
        return fourMatchesCount;
    }

    public int getFiveMatchesCount() {
        return fiveMatchesCount;
    }

    public int getFiveMatchesWithBonusCount() {
        return fiveMatchesWithBonusCount;
    }

    public int getSixMatchesCount() {
        return sixMatchesCount;
    }

    public double getYield(int totalInvestment) {
        int totalPrize = (sixMatchesCount * FIRST_PRIZE) +
                (fiveMatchesWithBonusCount * SECOND_PRIZE) +
                (fiveMatchesCount * THIRD_PRIZE) +
                (fourMatchesCount * FOURTH_PRIZE) +
                (threeMatchesCount * FIFTH_PRIZE);

        return (double) totalPrize / totalInvestment;
    }
}