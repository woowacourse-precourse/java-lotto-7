package lotto.model;

import lotto.util.Validation;

public class YieldCalculator {

    public static double calculateYield(MyWallet myWallet) {
        int money = myWallet.getMoney();
        long winnings = myWallet.getWinnings();
        Validation.validateMoneyInMyWallet(money);

        return ((double) winnings / money) * 100;
    }

}
