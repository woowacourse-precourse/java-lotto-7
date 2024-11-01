package lotto.domain.purchase;

public class Purchase {

    private static final String ERROR_NOT_INTEGER = "[ERROR] 정수 값이 입력되어야 합니다.";
    private static final String ERROR_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;

    public Purchase(String input) {
        validateInput(input);
        int purchaseAmount = Integer.parseInt(input);
        validateMoney(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getAmount() {
        return purchaseAmount;
    }

    public int numberOfLotto() {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void validateInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    private void validateMoney(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT);
        }
    }
}
