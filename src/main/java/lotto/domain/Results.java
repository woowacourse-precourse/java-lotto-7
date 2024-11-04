package lotto.domain;

import java.math.BigDecimal;
import java.util.List;
import lotto.common.LottoResults;

public class Results {
    private static final BigDecimal HUNDRED = new BigDecimal("100");
    private final List<LottoResults> lottoResults;

    public Results(final List<LottoResults> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public BigDecimal getSum() {
        BigDecimal sum = new BigDecimal(0);
        for (LottoResults lottoResult : lottoResults) {
            sum = sum.add(lottoResult.getWinningAmount());
        }
        return sum;
    }

    public BigDecimal getProfitRatio(final LottoPayment lottoPayment) {
        final BigDecimal sum = this.getSum();
        final BigDecimal payment = lottoPayment.getPayment();

        return sum.divide(payment).multiply(HUNDRED);
    }

    public long getCount(final LottoResults targetResult) {
        return this.lottoResults.stream()
                .filter(lottoResult -> lottoResult.equals(targetResult))
                .count();
    }

    public LottoStatisticsInfo getStatistics(final LottoResults lottoResult) {
        return new LottoStatisticsInfo(
                lottoResult.getConditionInformation(),
                lottoResult.getWinningAmount().intValue(),
                getCount(lottoResult)
        );
    }
}
