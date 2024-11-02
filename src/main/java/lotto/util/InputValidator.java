package lotto.util;

public class InputValidator {

    private static final String PURCHASE_AMOUNT_PREFIX = "금액: ";
    private static final Integer MIN_LOTTO_RANGE = 1;
    private static final Integer MAX_LOTTO_RANGE = 45;

    public void validatePurchaseAmount(int purchaseAmount, int lottoPrice) {
        if (purchaseAmount % lottoPrice != 0) {
            throw new IllegalArgumentException(
                    ErrorMessage.PURCHASE_AMOUNT_NOT_DIVISION_ERROR.getMessage()
                            + PURCHASE_AMOUNT_PREFIX
                            + purchaseAmount);
        }
    }

    public void validateBonusNumber(int number) {
        if (number < MIN_LOTTO_RANGE || number > MAX_LOTTO_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE_ERROR.getMessage());
        }
    }

}
