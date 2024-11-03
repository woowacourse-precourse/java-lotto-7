package lotto.domain;

public class Profit {
    private final double profit;

    private Profit(double profit) {
        this.profit = profit;
    }

    public static Profit of(Money money, WinningResult winningResult) {
        int purchaseMoney = money.getPurchaseQuantity() * 1000;
        int winningMoney = winningResult.getWinningMoney();

        return new Profit((double) winningMoney / purchaseMoney * 100);
    }

    public String getProfitString() {
        return String.format("총 수익률은 %.1f%%입니다.", profit);
    }
}
