package lotto.model;

import lotto.util.Validation;

public class YieldCalculator {

    public static float calculateYield(MyWallet myWallet){
        int money = myWallet.getMoney();
        long winnings = myWallet.getWinnings();

        float yield = ((float) winnings) / money * 100;
        return Math.round(yield * 100) / 100.0f;
    }

}
