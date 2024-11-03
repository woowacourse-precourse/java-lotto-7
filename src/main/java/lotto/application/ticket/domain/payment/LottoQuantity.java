package lotto.application.ticket.domain.payment;

public class LottoQuantity {
    private static final int MINIMUM_QUANTITY = 1;
    private static final int MAXIMUM_QUANTITY = 100;

    private final int value;

    public LottoQuantity(int value) {
        this.value = value;
    }

    public static LottoQuantity of(int count) {
        validateInValidRange(count);

        return new LottoQuantity(count);
    }

    private void validate(int count) {
        validateInValidRange(count);
    }

    private static void validateInValidRange(int count) {
        validateMinimumQuantity(count);
        validateMaximumQuantity(count);
    }

    private static void validateMaximumQuantity(int count) {
        if (count < MINIMUM_QUANTITY) {
            throw new IllegalArgumentException("[ERROR] 로또 수량은 1개 이상이어야 합니다.");
        }
    }

    private static void validateMinimumQuantity(int count) {
        if (count > MAXIMUM_QUANTITY) {
            throw new IllegalArgumentException("[ERROR] 로또 수량은 100개를 초과할 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }

}
