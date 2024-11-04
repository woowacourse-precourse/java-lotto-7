package lotto.model;

public class Profit {
    private int profit;
    private double profitRate;

    public Profit() {
        this.profit = 0;
        this.profitRate = 0;
    }

    public void addProfit(int profit) {
        this.profit += profit;
    }

    public int getProfit() {
        return this.profit;
    }

    public void setProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public double getProfitRate() {
        return this.profitRate;
    }
}
