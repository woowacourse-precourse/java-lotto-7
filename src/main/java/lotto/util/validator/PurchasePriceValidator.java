package lotto.util.validator;

public class PurchasePriceValidator {

    private static final String INVALID_PRICE_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.";

    public static void validatePurchasePrice(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PRICE_ERROR_MESSAGE);
        }
    }
}
