package lotto.domain.player;

public class PlayerResult {

    private final int firstPlace;
    private final int secondPlace;
    private final int thirdPlace;
    private final int fourthPlace;
    private final int fifthPlace;

    private final long profit;
    private final float profitRate;

    public PlayerResult(){
        this.firstPlace = 0;
        this.secondPlace = 0;
        this.thirdPlace = 0;
        this.fourthPlace = 0;
        this.fifthPlace = 0;

        this.profit = 0;
        this.profitRate = 0;
    }

    public PlayerResult(
            int firstPlace,
            int secondPlace,
            int thirdPlace,
            int fourthPlace,
            int fifthPlace
    ){
        this.firstPlace = firstPlace;
        this.secondPlace = secondPlace;
        this.thirdPlace = thirdPlace;
        this.fourthPlace = fourthPlace;
        this.fifthPlace = fifthPlace;

        this.profit = 0;
        this.profitRate = 0;
    }

    public int getFirstPlace() {
        return firstPlace;
    }

    public int getSecondPlace() {
        return secondPlace;
    }

    public int getThirdPlace() {
        return thirdPlace;
    }

    public int getFourthPlace() {
        return fourthPlace;
    }

    public int getFifthPlace() {
        return fifthPlace;
    }

    public long getProfit() {
        return profit;
    }

    public float getProfitRate() {
        return profitRate;
    }

}
