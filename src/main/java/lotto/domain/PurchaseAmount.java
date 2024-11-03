package lotto.domain;

public class PurchaseAmount {

    public static final int UNIT = 1000;
    public static final int MIN_AMOUNT = 0;

    private final int amount;

    private PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static PurchaseAmount from(String amount) {
        return new PurchaseAmount(toInt(amount));
    }

    private void validate(int amount) {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 구입 금액은 %,d보다 작을 수 없습니다.", MIN_AMOUNT));
        }
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 구입 금액은 %,d원 단위여야 합니다.", UNIT));
        }
    }

    private static int toInt(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수여야 합니다.");
        }
    }

    public Money toMoney() {
        return new Money(amount);
    }

}
