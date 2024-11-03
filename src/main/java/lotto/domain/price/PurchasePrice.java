package lotto.domain.price;

import java.math.BigDecimal;
import lotto.domain.quantity.Quantity;
import lotto.exception.price.InvalidPurchasePriceException;

public class PurchasePrice {

    public static final BigDecimal LOTTO_UNIT_PRICE = BigDecimal.valueOf(1000);

    private final BigDecimal price;

    public PurchasePrice(final String input) {
        validateLength(input);

        BigDecimal price = parse(input);
        validateNumber(price);
        this.price = price;
    }

    public Quantity calculateQuantity() {
        return new Quantity(price.divide(LOTTO_UNIT_PRICE));
    }

    private void validateLength(final String input) {
        if (input == null) {
            throw new InvalidPurchasePriceException("구입 금액은 null이 될 수 없습니다");
        }
        if (input.isBlank()) {
            throw new InvalidPurchasePriceException("구입 금액은 비어있거나 공백일 수 없습니다");
        }
    }

    private BigDecimal parse(final String input) {
        try {
            return new BigDecimal(input.trim());
        } catch (NumberFormatException e) {
            throw new InvalidPurchasePriceException("구입 금액은 숫자로만 이루어져야 합니다");
        }
    }

    private void validateNumber(final BigDecimal price) {
        if (price.scale() > 0) {
            throw new InvalidPurchasePriceException("구입 금액은 숫자로만 이루어져야 합니다");
        }
        if (isNotDivisible(price)) {
            throw new InvalidPurchasePriceException("구입 금액이 1000원 단위가 아닙니다");
        }
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPurchasePriceException("구입 금액은 자연수여야 합니다");
        }
    }

    private boolean isNotDivisible(final BigDecimal price) {
        return !price.remainder(LOTTO_UNIT_PRICE).equals(BigDecimal.ZERO);
    }
}
