package lotto.domain.quantity;

import java.math.BigDecimal;
import java.util.Objects;
import lotto.exception.argument.quantity.InvalidQuantityException;

public class Quantity {

    private final BigDecimal quantity;

    public Quantity(final BigDecimal quantity) {
        validate(quantity);
        this.quantity = quantity;
    }

    private void validate(final BigDecimal quantity) {
        if (quantity.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidQuantityException("수량은 자연수여야 합니다.");
        }
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Quantity other = (Quantity) o;
        return Objects.equals(quantity, other.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
