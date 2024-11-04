package lotto;

public class Statistics {
    private final int firstPrizeCount;
    private final int secondPrizeCount;
    private final int thirdPrizeCount;
    private final int fourthPrizeCount;
    private final int fifthPrizeCount;
    private final int totalPurchaseAmount;

    public Statistics(int firstPrizeCount, int secondPrizeCount, int thirdPrizeCount,
                      int fourthPrizeCount, int fifthPrizeCount, int totalPurchaseAmount) {
        this.firstPrizeCount = firstPrizeCount;
        this.secondPrizeCount = secondPrizeCount;
        this.thirdPrizeCount = thirdPrizeCount;
        this.fourthPrizeCount = fourthPrizeCount;
        this.fifthPrizeCount = fifthPrizeCount;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public int getFirstPrizeCount() {
        return firstPrizeCount;
    }

    public int getSecondPrizeCount() {
        return secondPrizeCount;
    }

    public int getThirdPrizeCount() {
        return thirdPrizeCount;
    }

    public int getFourthPrizeCount() {
        return fourthPrizeCount;
    }

    public int getFifthPrizeCount() {
        return fifthPrizeCount;
    }

    public double getRateOfReturn() {
        long totalPrize = (long) firstPrizeCount * Rank.FIRST.getPrize() +
                (long) secondPrizeCount * Rank.SECOND.getPrize() +
                (long) thirdPrizeCount * Rank.THIRD.getPrize() +
                (long) fourthPrizeCount * Rank.FOURTH.getPrize() +
                (long) fifthPrizeCount * Rank.FIFTH.getPrize();
        return ((double) totalPrize / totalPurchaseAmount) * 100;
    }
}
