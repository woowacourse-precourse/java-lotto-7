package lotto;

public class LottoPurchase {
    private final static String INVALID_NUMBER_FORMAT_MESSAGE = "[ERROR] 유효하지 않는 숫자 형식입니다.";
    private final static String LOTTO_PURCHASE_UNIT_ERROR_MESSAGE = "[ERROR] 로또는 1,000원 단위로 구입할 수 있습니다.";
    private final static String NEGATIVE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액은 양수만 입력할 수 있습니다.";
    private final static int LOTTO_PRICE = 1000;
    private final static int ZERO = 0;
    final long purchaseAmount;

    public LottoPurchase(String purchaseAmount) {
        this.purchaseAmount = validate(purchaseAmount);
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    private long validate(String inputAmount) {
        long amount;
        try {
            amount = Long.parseLong(inputAmount);
            validatePurchaseAmount(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
        return amount;
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(LOTTO_PURCHASE_UNIT_ERROR_MESSAGE);
        } else if (purchaseAmount < ZERO) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT_ERROR_MESSAGE);
        }
    }
}
