package lotto.model;

public class YieldCalculator {

    public static float calculateYield(MyWallet myWallet){
        int money = myWallet.getMoney();
        int winnings = myWallet.getWinnings();

        if (money <= 0) {
            throw new IllegalArgumentException("[Error] 금액은 0보다 커야 합니다.");
        }

        float yield = ((float) winnings - money) / money * 100;
        return Math.round(yield * 100) / 100.0f;
    }
}
