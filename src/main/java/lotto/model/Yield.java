package lotto.model;

public class Yield {
    private final Integer totalMoney;
    private Integer sum = 0;

    public Yield(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void addReward(Integer reward) {
        sum += reward;
    }

    public double calculateRatio() {
        return ((double) sum / totalMoney) * 100;
    }
}
