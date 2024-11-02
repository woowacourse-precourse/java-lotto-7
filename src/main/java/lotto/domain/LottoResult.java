package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoReward, Integer> lottoResult;

    public LottoResult(List<LottoReward> lottoRewards) {
        lottoResult = new EnumMap<>(LottoReward.class);
        for (LottoReward lottoReward : LottoReward.values()) {
            lottoResult.put(lottoReward, Collections.frequency(lottoRewards, lottoReward));
        }
    }

    public Map<LottoReward, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }

    public double calculateProfit(PurchasePrice purchasePrice) {
        return (double) (calculateTotalPrize() - purchasePrice.getMoney()) / purchasePrice.getMoney() * 100 + 100;
    }

    private int calculateTotalPrize() {
        return lottoResult.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
