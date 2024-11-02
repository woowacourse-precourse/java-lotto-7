package lotto.domain;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int calculateLottoCount() {
        return amount / LOTTO_PRICE;
    }

    private void validate(int amount) {
        validatePositive(amount);
        validateThousandUnit(amount);
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
        }
    }

    private static void validateThousandUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 정수여야 합니다.");
        }
    }
}
