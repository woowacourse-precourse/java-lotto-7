package domain.prize;

public class PrizeResult {
    private int firstCount;
    private int secondCount;
    private int thirdCount;
    private int fourthCount;
    private int fifthCount;

    public void addPrize(Prize prize) {
        switch (prize) {
            case FIRST:
                firstCount++;
                break;
            case SECOND:
                secondCount++;
                break;
            case THIRD:
                thirdCount++;
                break;
            case FOURTH:
                fourthCount++;
                break;
            case FIFTH:
                fifthCount++;
                break;
            default:
                break;
        }
    }

    public int getFirstCount() {
        return firstCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public int getThirdCount() {
        return thirdCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }

    public int getFifthCount() {
        return fifthCount;
    }

    public long calculateTotalPrize() {
        return (long) firstCount * Prize.FIRST.getPrizeMoney()
                + (long) secondCount * Prize.SECOND.getPrizeMoney()
                + (long) thirdCount * Prize.THIRD.getPrizeMoney()
                + (long) fourthCount * Prize.FOURTH.getPrizeMoney()
                + (long) fifthCount * Prize.FIFTH.getPrizeMoney();
    }
}