package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoValue {
    private final BigDecimal lottoPrice;
    private final int lottoCount;

    public LottoValue(BigDecimal lottoPrice) {
        this.lottoPrice = lottoPrice;
        this.lottoCount = lottoPrice.divide(BigDecimal.valueOf(1000), 2, RoundingMode.HALF_UP)
                .intValue();
    }

    public BigDecimal lottoPrice() {
        return lottoPrice;
    }

    public int lottoCount() {
        return lottoCount;
    }
}
