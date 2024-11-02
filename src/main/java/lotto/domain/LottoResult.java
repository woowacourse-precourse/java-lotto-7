package lotto.domain;

import lotto.util.constant.LottoConstants;

import java.util.EnumMap;
import java.util.Map;

import static lotto.util.constant.LottoConstants.*;

public class LottoResult {
    private static final Map<LottoPrize, Integer> prizeCountMap = new EnumMap<>(LottoPrize.class);
    private static float profit;

    public static float getProfit() {
        return profit;
    }

    public static void setProfit(float profit) {
        LottoResult.profit = profit;
    }

    public LottoResult() {
        // 모든 당첨 등수를 0으로 초기화
        for (LottoPrize prize : LottoPrize.values()) {
            prizeCountMap.put(prize, ZERO);
        }
    }

    // 특정 등수의 당첨 횟수를 증가시키는 메서드
    public void incrementPrizeCount(LottoPrize prize) {
        prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
    }

    // 특정 등수의 당첨 횟수를 반환하는 메서드
    public static int getPrizeCount(LottoPrize prize) {
        return prizeCountMap.getOrDefault(prize, ZERO);
    }

    public static int getTotalPrize(){
        int totalPrize = ZERO;
        for (LottoPrize prize : prizeCountMap.keySet()){
            totalPrize += prize.getPrizeMoney() * getPrizeCount(prize);
        }
        return totalPrize;
    }



}
