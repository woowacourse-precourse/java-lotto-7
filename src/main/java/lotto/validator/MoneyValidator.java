package lotto.validator;

public class MoneyValidator {
    private static final int MIN_AMOUNT = 1000;
    private static final int UNIT_AMOUNT = 1000;
    private static final long MAX_AMOUNT = Integer.MAX_VALUE;

    public static void validate(long amount) {
        validateMinAmount(amount);
        validateMaxAmount(amount);
        validateUnitAmount(amount);
    }

    private static void validateMinAmount(long amount) {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
    }

    private static void validateMaxAmount(long amount) {
        if (amount > MAX_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 너무 큽니다.");
        }
    }

    private static void validateUnitAmount(long amount) {
        if (amount % UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
