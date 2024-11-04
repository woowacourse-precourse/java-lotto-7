package lotto.domain.lotto;

import java.util.Objects;

public class PurchaseAmount {

    private static final long LOTTO_TICKET_PRICE = 1_000L;
    private static final long MAX_PURCHASE_AMOUNT = 100_000L;

    private final long value;

    public PurchaseAmount(final long value) {
        validateAmountUnit(value);
        validateOutOfRange(value);
        this.value = value;
    }

    public long getCountOfTicket() {
        return value / LOTTO_TICKET_PRICE;
    }

    private void validateAmountUnit(final long value) {
        if ((value % LOTTO_TICKET_PRICE != 0)) {
            throw new IllegalArgumentException("구입금액은 1,000원 단위여야 합니다.");
        }
    }

    private void validateOutOfRange(final long value) {
        if (value < LOTTO_TICKET_PRICE || value > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("구입금액은 1,000~100,000원까지 가능합니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PurchaseAmount that)) {
            return false;
        }
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "PurchaseAmount{" +
                "value=" + value +
                '}';
    }

}
