package lotto.model;

import static java.math.RoundingMode.HALF_UP;
import static lotto.model.Lottos.WINING_RATE_DECIMAL_PLACE;

import java.math.BigDecimal;

public class LottoValue {
    public static final int LOTTO_PRICE_DIVISOR = 1000;
    private final BigDecimal lottoPrice;
    private final int lottoCount;

    public LottoValue(BigDecimal lottoPrice) {
        this.lottoPrice = lottoPrice;
        this.lottoCount = calculateCount(lottoPrice);
    }

    private static int calculateCount(BigDecimal lottoPrice) {
        return lottoPrice.divide(BigDecimal.valueOf(LOTTO_PRICE_DIVISOR), WINING_RATE_DECIMAL_PLACE, HALF_UP)
                .intValue();
    }

    public BigDecimal lottoPrice() {
        return lottoPrice;
    }

    public int lottoCount() {
        return lottoCount;
    }
}
