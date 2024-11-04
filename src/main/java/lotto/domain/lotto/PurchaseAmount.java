package lotto.domain.lotto;

public class PurchaseAmount {

    private static final String SHOULD_INTEGER_MESSAGE = "[ERROR] 구입금액을 숫자로 입력해주세요.";
    private static final String SHOULD_DIVISIBLE_BY_THOUSAND_MESSAGE = "[ERROR] 구입금액을 1000원 단위로 입력해주세요.";
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

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
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(SHOULD_DIVISIBLE_BY_THOUSAND_MESSAGE);
        }
    }

    public int calculateLottoCount() {
        return amount / LOTTO_PRICE;
    }
}
