package lotto.domain;

import lotto.enums.LottoPrice;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoPriceMap {
    private final Map<String, Integer> prizes;

    public LottoPriceMap() {
        this.prizes = initializePrizes();
    }

    private Map<String, Integer> initializePrizes() {
        Map<String, Integer> setPrizes = new LinkedHashMap<>();
        setPrizes.put("3개 일치", LottoPrice.THREE_WINNING_PRICE.getPrice());
        setPrizes.put("4개 일치", LottoPrice.FOUR_WINNING_PRICE.getPrice());
        setPrizes.put("5개 일치", LottoPrice.FIVE_WINNING_PRICE.getPrice());
        setPrizes.put("5개 일치, 보너스 볼 일치", LottoPrice.FIVE_WINNING_WITH_BONUS_PRICE.getPrice());
        setPrizes.put("6개 일치", LottoPrice.SIX_WINNING_PRICE.getPrice());
        return setPrizes;
    }

    public Map<String, Integer> getPrizes() {
        return prizes;
    }
}
