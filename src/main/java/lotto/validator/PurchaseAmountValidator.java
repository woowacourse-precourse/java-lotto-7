package lotto.validator;

public class PurchaseAmountValidator {
    private final int LIMIT_AMOUNT = 1000;

    public void validate(String amount) {
        if (!amount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수여야 합니다.");
        }
        if (Integer.parseInt(amount) < LIMIT_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (!(Integer.parseInt(amount) % LIMIT_AMOUNT == 0)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위어야 합니다.");
        }
    }
}
