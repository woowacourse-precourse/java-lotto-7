package lotto.domain;

public class PurchaseAmount {

    private static final int UNIT_AMOUNT = 1000;
    private static final String ERROR_NOT_DIVISIBLE = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    private static final String ERROR_NON_POSITIVE = "[ERROR] 구입 금액은 0원보다 커야 합니다.";

    private final int amount;

    public PurchaseAmount(int amount) {
        this.amount = amount;
        validatePurchaseAmount();
    }

    public int getAmount() {
        return amount;
    }

    private void validatePurchaseAmount() {
        validatePositiveAmount();
        validateDivisibleByThousand();
    }

    private void validateDivisibleByThousand() {
        if (isNotDivisibleByThousand()) {
            throw new IllegalArgumentException(ERROR_NOT_DIVISIBLE);
        }
    }

    private boolean isNotDivisibleByThousand() {
        return amount % UNIT_AMOUNT != 0;
    }

    private void validatePositiveAmount() {
        if (isNegativeOrZero()) {
            throw new IllegalArgumentException(ERROR_NON_POSITIVE);
        }
    }

    private boolean isNegativeOrZero() {
        return amount <= 0;
    }

}
