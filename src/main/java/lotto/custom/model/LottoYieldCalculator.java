package lotto.custom.model;

import java.util.List;

public class LottoYieldCalculator {
    public double run(List<Integer> result, int purchaseAmount) {
        int index = 0;
        double revenue = 0;

        for (LottoPrize prize : LottoPrize.values()) {
            revenue += prize.getPrizeMoney() * result.get(index++);
        }
        return revenue / purchaseAmount * 100; // 수익률 = (총 수익금 / 투자금) * 100
    }
}