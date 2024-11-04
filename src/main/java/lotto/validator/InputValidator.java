package lotto.validator;

public class InputValidator {

    private final int LOTTO_PRICE = 1000;

    public int validatePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount / LOTTO_PRICE;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }
}

