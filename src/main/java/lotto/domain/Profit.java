package lotto.domain;

import lotto.util.Limit;

public class Profit {
    public static final int PERCENTAGE = 100;
    public static final String PROFIT_STRING_FORMAT = "총 수익률은 %.1f%%입니다.";

    private final double profit;

    private Profit(double profit) {
        this.profit = profit;
    }

    public static Profit of(Money money, WinningResult winningResult) {
        int purchaseMoney = money.getPurchaseQuantity() * Limit.PURCHASE_MONEY_UNIT;
        int winningMoney = winningResult.getWinningMoney();

        return new Profit((double) winningMoney / purchaseMoney * PERCENTAGE);
    }

    public String getProfitString() {
        return String.format(PROFIT_STRING_FORMAT, profit);
    }
}
