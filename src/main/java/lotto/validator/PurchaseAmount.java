package lotto.validator;

public class PurchaseAmount {

    private static final int PURCHASE_UNIT = 1000;
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String EMPTY_INPUT_ERROR = ERROR_PREFIX + "로또 구입 금액을 입력해 주세요.";
    private static final String NON_INTEGER_ERROR = ERROR_PREFIX + "%s: 정수가 아닙니다.";
    private static final String OVERFLOW_ERROR = ERROR_PREFIX + "%s: 너무 큰 값을 입력하였습니다.";
    private static final String NOT_MULTIPLE_OF_THOUSAND_ERROR = ERROR_PREFIX + "로또 구입 금액은 1,000원 단위로 입력해 주세요.";

    public void validatePurchaseAmount(String beforePurchaseAmount) {
        validateEmptyString(beforePurchaseAmount);
        validateIntegerInput(beforePurchaseAmount);
        int purchaseAmount = validateIntegerRange(beforePurchaseAmount);
        validateNotMultipleOfThousand(purchaseAmount);
    }

    private void validateEmptyString(String beforePurchaseAmount) {
        if (beforePurchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    private void validateIntegerInput(String beforePurchaseAmount) {
        try {
            Long.parseLong(beforePurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(NON_INTEGER_ERROR, beforePurchaseAmount));
        }
    }

    private int validateIntegerRange(String beforePurchaseAmount) {
        long longValue = Long.parseLong(beforePurchaseAmount);
        if ( longValue < Integer.MIN_VALUE || longValue > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(String.format(OVERFLOW_ERROR, longValue));
        }
        return Integer.parseInt(beforePurchaseAmount);
    }

    private void validateNotMultipleOfThousand(int purchaseAmount) {
        if (purchaseAmount % PURCHASE_UNIT != 0 && purchaseAmount >= PURCHASE_UNIT) {
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_THOUSAND_ERROR);
        }
    }

}
