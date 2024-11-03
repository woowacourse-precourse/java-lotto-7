package lotto.domain;

import java.math.BigDecimal;

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
}
