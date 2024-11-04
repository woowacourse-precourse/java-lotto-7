package lotto.temp;

import lotto.util.Limit;

public class Statics {
    private static final float FLOAT_FORMAT = 10.0f;

    public float calculateProfit(int money, int totalPrize){
        float profit = ((float)totalPrize / money) * Limit.PERCENT.getValue();
        return Math.round(profit * Limit.TEN.getValue()) / FLOAT_FORMAT;
    }

}
