package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoPrize, Long> prizeCounts = new EnumMap<>(LottoPrize.class);
    private long totalProfit;
    private final long userPurchaseMoney;

    private LottoResult(long userPurchaseMoney) {
        for (LottoPrize prize : LottoPrize.values()) {
            prizeCounts.put(prize, 0L);
        }
        this.totalProfit = 0;
        this.userPurchaseMoney = userPurchaseMoney;
    }

    public static LottoResult createLottoResult(long userPurchaseMoney) {
        return new LottoResult(userPurchaseMoney);
    }

    public void addPrize(LottoPrize prize) {
        prizeCounts.put(prize, prizeCounts.get(prize) + 1);
        totalProfit += prize.getPrice();
    }

    public double calculateYield() {
        return (double) totalProfit / userPurchaseMoney * 100;
    }

    public long getLottoPrizeCounts(LottoPrize lottoPrize) {
        return prizeCounts.get(lottoPrize);
    }
}
