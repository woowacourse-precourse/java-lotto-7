package lotto.domain.price;

import java.math.BigDecimal;
import java.util.Objects;
import lotto.domain.quantity.Quantity;
import lotto.exception.argument.price.InvalidPriceException;

public class Price {

    public static final BigDecimal LOTTO_UNIT_PRICE = BigDecimal.valueOf(1000);

    private final BigDecimal price;

    public Price(final BigDecimal price) {
        validate(price);
        this.price = price;
    }

    public Quantity calculateQuantity() {
        return new Quantity(price.divide(LOTTO_UNIT_PRICE));
    }

    private void validate(final BigDecimal price) {
        if (price.stripTrailingZeros().scale() > 0) {
            throw new InvalidPriceException("구입 금액은 숫자로만 이루어져야 합니다.");
        }
        if (isNotDivisible(price)) {
            throw new InvalidPriceException("구입 금액이 1000원 단위가 아닙니다.");
        }
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPriceException("구입 금액은 자연수여야 합니다.");
        }
    }

    private boolean isNotDivisible(final BigDecimal price) {
        return !price.remainder(LOTTO_UNIT_PRICE).equals(BigDecimal.ZERO);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Price that = (Price) o;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
