package lotto;

public class PurchaseAmount {
    private static final String ERROR_INVALID_AMOUNT = "[ERROR] 구입금액은 1,000원 단위여야 합니다.";
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private final int amount;

    public PurchaseAmount(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_AMOUNT);
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoCount() {
        return amount / PURCHASE_AMOUNT_UNIT;
    }
}
