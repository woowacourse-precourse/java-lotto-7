package lotto.domain;

import static lotto.domain.LottoPrize.NO_PRIZE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class LottoPrizesRecord {
    private final Map<LottoPrize, Integer> lottoPrizesMap;

    public LottoPrizesRecord(Map<LottoPrize, Integer> lottoPrizesMap) {
        this.lottoPrizesMap = lottoPrizesMap;
    }

    public long totalEarningAmount() {
        return lottoPrizesMap.entrySet().stream()
                .filter(entry -> entry.getKey() != NO_PRIZE)
                .mapToLong(entry -> entry.getValue() * entry.getKey().getPrizeMoney())
                .sum();
    }

    public double getRateOfReturn(LottoPrice lottoPrice) {
        long totalEarningAmount = totalEarningAmount();
        int lottoPricePrice = lottoPrice.getPrice();

        BigDecimal rateOfReturn = BigDecimal.valueOf(totalEarningAmount)
                .multiply(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(lottoPricePrice), 2, RoundingMode.HALF_UP);
        return rateOfReturn.doubleValue();
    }

    public Map<LottoPrize, Integer> getLottoPrizesMap() {
        return lottoPrizesMap;
    }
}
