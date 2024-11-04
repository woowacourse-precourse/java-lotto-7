package lotto.domain;

public class Profit {
    private final double rate;


    public Profit(int totalProfit, int totalSpent) {
        this.rate = ((double) totalProfit / totalSpent) * 100;
    }

    public double getRate() {
        return rate;
    }
}
