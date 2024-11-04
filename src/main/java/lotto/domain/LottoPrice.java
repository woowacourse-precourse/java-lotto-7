package lotto.domain;

import static lotto.constant.lotto.LottoConstants.LOTTO_UNIT_PRICE;
import static lotto.exception.lottoPrice.LottoPriceErrorCode.INVALID_LOTTO_PRICE;

import java.math.BigDecimal;
import lotto.exception.LottoException;

public class LottoPrice {

    private final BigDecimal price;

    public LottoPrice(int price) {
        validate(price);
        this.price = BigDecimal.valueOf(price);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getCanPurchaseLottoCount() {
        return price.divide(LOTTO_UNIT_PRICE.getBigDecimalValue());
    }

    private void validate(int price) {
        validatePrice(price);
    }

    private void validatePrice(int price) {
        if (price < LOTTO_UNIT_PRICE.getIntValue() || price % LOTTO_UNIT_PRICE.getIntValue() != 0) {
            throw new LottoException(INVALID_LOTTO_PRICE);
        }
    }
}
