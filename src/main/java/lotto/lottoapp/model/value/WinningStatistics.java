package lotto.lottoapp.model.value;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

public record WinningStatistics(Map<WinningResult, Long> winningTotal, Won amountOfPaid) {

    public WinningStatistics {
        winningTotal = Collections.unmodifiableMap(winningTotal);
    }

    public Map.Entry<WinningResult, Long> findWinningBy(int rank) {
        return winningTotal.entrySet().stream()
                .filter(entry -> entry.getKey().ranking == rank)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 랭크입니다."));
    }

    public BigDecimal getRateReturn() {
        Won totalPrize = winningTotal.entrySet().stream().parallel()
                .map(winAndCount -> Won.of(winAndCount.getKey().prize.getIntValue() * winAndCount.getValue()))
                .reduce(Won.of(0), Won::add);
        return RateReturn.by(totalPrize, amountOfPaid).rateOfReturn();
    }

}
