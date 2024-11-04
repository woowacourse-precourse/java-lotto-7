package lotto.domain.player;

public class PlayerResult {

    private int firstPlace;
    private int secondPlace;
    private int thirdPlace;
    private int fourthPlace;
    private int fifthPlace;

    private long profit;
    private float profitRate;

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

    public void increaseFirstPlace() {
        this.firstPlace++;
    }

    public void increaseSecondPlace() {
        this.secondPlace++;
    }

    public void increaseThirdPlace() {
        this.thirdPlace++;
    }

    public void increaseFourthPlace() {
        this.fourthPlace++;
    }

    public void increaseFifthPlace() {
        this.fifthPlace++;
    }

    public void updateProfit(long profit) {
        this.profit = profit;
    }

    public void updateProfitRate(float profitRate) {
        this.profitRate = profitRate;
    }
}
