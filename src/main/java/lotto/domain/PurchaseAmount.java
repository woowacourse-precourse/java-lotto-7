package lotto.domain;

public class PurchaseAmount {
    private static final int UNIT_PRICE = 1000;
    private final int amount;

    private PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static PurchaseAmount from(String input) {
        validateNumberFormat(input);
        try {
            return new PurchaseAmount(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 너무 큽니다.");
        }
    }

    private static void validateNumberFormat(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validate(int amount) {
        validatePositiveAmount(amount);
        validateThousandUnit(amount);
    }

    private void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
    }

    private void validateThousandUnit(int amount) {
        if (amount % UNIT_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public int getAmount() {
        return amount;
    }
}
