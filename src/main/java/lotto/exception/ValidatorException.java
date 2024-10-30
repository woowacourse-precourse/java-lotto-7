package lotto.exception;

public class ValidatorException {

    public static void throwIfPurchasePriceIsBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(ErrorCause.INPUT_VALUE.getMessage());
        }
    }

    public static void throwIfPurchasePriceIsNotNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCause.INPUT_VALUE.getMessage());
        }
    }

    public static void throwIfPurchasePriceNotMatchToUnit(String value, int lottoPrice) {
        int purchaseAmount = Integer.parseInt(value);
        if (purchaseAmount % lottoPrice != 0) {
            throw new IllegalArgumentException(
                    ErrorCause.PURCHASE_AMOUNT_UNIT.getMessage() + "(로또 1장: " + lottoPrice + "원)"
            );
        }
    }
}
