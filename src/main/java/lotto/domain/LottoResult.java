package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoPrize, Long> prizeCounts = new EnumMap<>(LottoPrize.class);
    private long totalProfit;

    private LottoResult() {
        for (LottoPrize prize : LottoPrize.values()) {
            prizeCounts.put(prize, 0L);
        }
        this.totalProfit = 0;
    }

    public static LottoResult createLottoResult() {
        return new LottoResult();
    }

    public void addPrize(LottoPrize prize) {
        prizeCounts.put(prize, prizeCounts.get(prize) + 1);
        totalProfit += prize.getPrice();
    }

    public long getLottoPrizeCounts(LottoPrize lottoPrize) {
        return prizeCounts.get(lottoPrize);
    }

    public long getTotalProfit() {
        return totalProfit;
    }
}
