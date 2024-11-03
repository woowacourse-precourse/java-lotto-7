package lotto.dto;

import static lotto.domain.LottoPrize.NO_PRIZE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import lotto.domain.LottoPrice;
import lotto.domain.LottoPrize;

public record LottoPrizesRecord(Map<LottoPrize, Integer> lottoPrizesMap) {

    public BigDecimal totalEarningAmount() {
        return lottoPrizesMap.entrySet().stream()
                .filter(entry -> entry.getKey() != NO_PRIZE)
                .map(entry -> BigDecimal.valueOf(entry.getValue())
                        .multiply(BigDecimal.valueOf(entry.getKey().getPrizeMoney())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getRateOfReturn(LottoPrice lottoPrice) {
        BigDecimal totalEarningAmount = totalEarningAmount();

        BigDecimal rateOfReturn = totalEarningAmount
                .multiply(BigDecimal.valueOf(100))
                .divide(lottoPrice.getPrice(), 1, RoundingMode.HALF_UP);
        return rateOfReturn;
    }
}
