package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoPrize, Integer> prizeCountMap;

    public LottoResult() {
        prizeCountMap = new EnumMap<>(LottoPrize.class);
        for (LottoPrize prize : LottoPrize.values()) {
            prizeCountMap.put(prize, 0);
        }
    }

    public void updateLottoResult(final int matchingCount, final boolean isBonus) {
        LottoPrize prize = LottoPrize.valueOf(matchingCount, isBonus);
        if (prize != null) {
            prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
        }
    }

    public void printLottoWinningStatistics() {
        for (LottoPrize prize : LottoPrize.values()) {
            int count = prizeCountMap.get(prize);
            System.out.println(prize.getDescription() + " - " + count + "개");
        }
    }
}
