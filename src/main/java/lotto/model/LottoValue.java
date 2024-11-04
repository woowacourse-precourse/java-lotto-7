package lotto.model;

import static java.math.BigDecimal.*;
import static java.math.RoundingMode.HALF_UP;
import static lotto.model.Lottos.WINING_RATE_DECIMAL_PLACE;

import java.math.BigDecimal;

public class LottoValue {
    public static final int LOTTO_PRICE_DIVISOR = 1000;
    private final BigDecimal lottoPrice;
    private final int lottoCount;

    public LottoValue(BigDecimal lottoPrice) {
        validatePrice(lottoPrice);
        this.lottoPrice = lottoPrice;
        this.lottoCount = calculateCount();
        validateMinCount();
    }

    private void validateMinCount() {
        if (lottoCount <= 0) {
            throw new IllegalArgumentException("구매 갯수는 1개 이상이어야 합니다.");
        }
    }

    private static void validatePrice(BigDecimal lottoPrice) {
        if (!lottoPrice.remainder(valueOf(1000)).equals(ZERO)) {
            throw new IllegalArgumentException("구입금액은 1000 단위여야합니다.");
        }
    }

    private int calculateCount() {
        return lottoPrice.divide(valueOf(LOTTO_PRICE_DIVISOR), WINING_RATE_DECIMAL_PLACE, HALF_UP)
                .intValue();
    }

    public BigDecimal lottoPrice() {
        return lottoPrice;
    }

    public int lottoCount() {
        return lottoCount;
    }
}