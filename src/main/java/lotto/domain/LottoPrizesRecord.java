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

    public BigDecimal totalEarningAmount() {
        return lottoPrizesMap.entrySet().stream()
                .filter(entry -> entry.getKey() != NO_PRIZE)
                .map(entry -> BigDecimal.valueOf(entry.getValue()).multiply(BigDecimal.valueOf(entry.getKey().getPrizeMoney())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getRateOfReturn(LottoPrice lottoPrice) {
        BigDecimal totalEarningAmount = totalEarningAmount();

        BigDecimal rateOfReturn = totalEarningAmount
                .multiply(BigDecimal.valueOf(100))
                .divide(lottoPrice.getPrice(), 1, RoundingMode.HALF_UP);
        return rateOfReturn;
    }

    public Map<LottoPrize, Integer> getLottoPrizesMap() {
        return lottoPrizesMap;
    }
}
