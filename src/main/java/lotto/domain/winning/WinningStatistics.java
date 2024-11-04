package lotto.domain.winning;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WinningStatistics {

    private final Map<LottoRank, Long> statistics;

    private WinningStatistics(final Map<LottoRank, Long> statistics) {
        this.statistics = statistics;
    }

    public static WinningStatistics create() {
        Map<LottoRank, Long> emptyStatistics = new EnumMap<>(LottoRank.class);
        initStatistics(emptyStatistics);
        return new WinningStatistics(emptyStatistics);
    }

    public void save(final LottoRank lottoRank) {
        statistics.computeIfPresent(lottoRank, (key, value) -> value + 1L);
    }

    public long getWinningCount(final LottoRank lottoRank) {
        return statistics.get(lottoRank);
    }

    public BigDecimal calculateReturnOnInvestment(final long totalAmount) {
        BigDecimal winningMoneyTotal = calculateWinningMoneyTotal();
        return winningMoneyTotal.divide(BigDecimal.valueOf(totalAmount), MathContext.DECIMAL64);
    }

    private BigDecimal calculateWinningMoneyTotal() {
        BigDecimal winningMoneyTotal = BigDecimal.ZERO;
        for (LottoRank lottoRank : statistics.keySet()) {
            long winningCount = statistics.get(lottoRank);
            winningMoneyTotal = winningMoneyTotal.add(
                    BigDecimal.valueOf(lottoRank.calculateWinningMoneyTotal(winningCount))
            );
        }
        return winningMoneyTotal;
    }

    private static void initStatistics(final Map<LottoRank, Long> emptyStatistics) {
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> emptyStatistics.put(lottoRank, 0L));
    }

}
