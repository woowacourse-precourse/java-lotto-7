package lotto.domain;

import static lotto.exception.lottoPrice.LottoPriceErrorCode.INVALID_LOTTO_PRICE;

import java.math.BigDecimal;
import lotto.exception.LottoException;

public class LottoPrice {
    private static final BigDecimal LOTTO_UNIT_PRICE = BigDecimal.valueOf(1000);
    private final BigDecimal price;

    public LottoPrice(int price) {
        this.price = BigDecimal.valueOf(price);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getCanPurchaseLottoCount() {
        return price.divide(LOTTO_UNIT_PRICE);
    }

    private void validate(int price) {
        validatePrice(price);
    }

    private void validatePrice(int price) {
        if (price <= 0 || price % 1000 != 0) {
            throw new LottoException(INVALID_LOTTO_PRICE);
        }
    }
}
