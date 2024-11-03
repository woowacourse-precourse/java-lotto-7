package lotto.model;

public class ProfitRate {

    public static float profitRate(Integer userPurchaseMoney, Integer totalPurchaseMoney) {
        float roi = (totalPurchaseMoney / (float) userPurchaseMoney) * 100;
        return Math.round(roi * 100) / 100.0f;
    }
}
