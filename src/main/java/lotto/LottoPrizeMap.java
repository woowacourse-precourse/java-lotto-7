package lotto;

import lotto.enums.LottoPrize;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoPrizeMap {
    private Map<String, Integer> prizes;

    public LottoPrizeMap() {
        this.prizes = createPrizes();
    }

    private Map<String, Integer> createPrizes() {
        Map<String, Integer> setPrizes = new LinkedHashMap<>();
        setPrizes.put("3개 일치", LottoPrize.THREE_WINNING_PRIZE.getPrize());
        setPrizes.put("4개 일치", LottoPrize.FOUR_WINNING_PRIZE.getPrize());
        setPrizes.put("5개 일치", LottoPrize.FIVE_WINNING_PRIZE.getPrize());
        setPrizes.put("5개 일치, 보너스 볼 일치", LottoPrize.FIVE_WINNING_WITH_BONUS_PRIZE.getPrize());
        setPrizes.put("6개 일치", LottoPrize.SIX_WINNING_PRIZE.getPrize());
        return setPrizes;
    }

    public Map<String, Integer> getPrizes() {
        return prizes;
    }
}
