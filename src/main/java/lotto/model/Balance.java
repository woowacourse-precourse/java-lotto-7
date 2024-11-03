package lotto.model;

public class Balance {
    private final int money;
    private final int ticket;
    private int profit;
    private double profitRate;

    public Balance(int money) {
        validate(money);
        this.money = money;
        this.ticket = this.money / 1000;
        this.profit = 0;
        this.profitRate = 0;
    }

    private void validate(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 이상이어야 합니다.");
        }
        else if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public int getMoney() {
        return this.money;
    }

    public int getTicket() {
        return this.ticket;
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
