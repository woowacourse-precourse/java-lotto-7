package lotto.domain;

public class PurchaseAmount {

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
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private boolean isNotDivisibleByThousand() {
        return amount % 1000 != 0;
    }

    private void validatePositiveAmount() {
        if (isNegativeOrZero()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0원보다 커야 합니다.");
        }
    }

    private boolean isNegativeOrZero() {
        return amount <= 0;
    }

}
