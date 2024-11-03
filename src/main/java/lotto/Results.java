package lotto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import lotto.common.LottoResult;

public class Results {

    private final List<LottoResult> lottoResults;

    public Results(final List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public BigDecimal getSum() {
        BigDecimal sum = new BigDecimal(0);
        for (LottoResult lottoResult : lottoResults) {
            sum = sum.add(lottoResult.getWinningAmount());
        }
        return sum;
    }

    public BigDecimal getProfitRatio(final LottoPayment lottoPayment) {
        final BigDecimal sum = this.getSum();
        final BigDecimal payment = lottoPayment.getPayment();

        return sum.divide(payment).multiply(new BigDecimal("100"));
    }
}
