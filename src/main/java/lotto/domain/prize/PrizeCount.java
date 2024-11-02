package lotto.domain.prize;

public class PrizeCount {
    private int firstPrizeCount;
    private int secondPrizeCount;
    private int thirdPrizeCount;
    private int fourthPrizeCount;
    private int fifthPrizeCount;

    public PrizeCount() {
        this.firstPrizeCount = 0;
        this.secondPrizeCount = 0;
        this.thirdPrizeCount = 0;
        this.fourthPrizeCount = 0;
        this.fifthPrizeCount = 0;
    }

    public void addOneFirstPrizeCount() {
        firstPrizeCount += 1;
    }

    public void addOneSecondPrizeCount() {
        secondPrizeCount += 1;
    }

    public void addOneThirdPrizeCount() {
        thirdPrizeCount += 1;
    }

    public void addOneFourthPrizeCount() {
        fourthPrizeCount += 1;
    }

    public void addOneFifthPrizeCount() {
        fifthPrizeCount += 1;
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
}
