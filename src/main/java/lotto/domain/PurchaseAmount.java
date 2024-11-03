package lotto.domain;

public class PurchaseAmount {

    public static final String SHOULD_INTEGER_MESSAGE = "[ERROR] 구입금액을 숫자로 입력해주세요.";
    public static final String SHOULD_DIVISIBLE_BY_THOUSAND_MESSAGE = "[ERROR] 구입금액을 1000원 단위로 입력해주세요.";
    private int amount;

    public PurchaseAmount(String rawPurchaseAmount) {
        int purchaseAmount = toInt(rawPurchaseAmount);
        validateDivisibleByThousand(purchaseAmount);
        this.amount = purchaseAmount;
    }

    private int toInt(String rawPurchaseAmount) {
        try {
            return Integer.parseInt(rawPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(SHOULD_INTEGER_MESSAGE);
        }
    }

    private void validateDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(SHOULD_DIVISIBLE_BY_THOUSAND_MESSAGE);
        }
    }
}
