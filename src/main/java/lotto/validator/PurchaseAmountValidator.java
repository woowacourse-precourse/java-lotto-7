package lotto.validator;

import lotto.view.OutputView;

public class PurchaseAmountValidator {
    private static final String PURCHASE_AMOUNT_NOT_NUMERIC_MESSAGE = "구입 금액에는 숫자만 입력할 수 있습니다.";
    private static final String PURCHASE_AMOUNT_NOT_IN_RANGE_MESSAGE = "1000만원 이상은 구매가 불가능합니다.";
    private static final String PURCHASE_AMOUNT_NOT_POSITIVE_MESSAGE = "구입 금액은 양수여야 합니다.";
    private static final String PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND_MESSAGE = "구입 금액은 1,000원 단위여야 합니다.";

    public static boolean checkValidPurchaseAmount(String inputAmount) throws IllegalArgumentException {
        try {
            checkPurchaseAmountIsNumeric(inputAmount);
            checkPurchaseAmountInRange(inputAmount);
            checkPurchaseAmountIsPositive(inputAmount);
            checkPurchaseAmountIsMultipleOfThousand(inputAmount);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }

    private static void checkPurchaseAmountIsNumeric(String inputAmount) throws IllegalArgumentException {
        if (!inputAmount.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_NUMERIC_MESSAGE);
        }
    }

    private static void checkPurchaseAmountInRange(String inputAmount) throws IllegalArgumentException {
        if (inputAmount.length() > 7) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_IN_RANGE_MESSAGE);
        }
    }

    private static void checkPurchaseAmountIsPositive(String inputAmount) throws IllegalArgumentException {
        long amount = Long.parseLong(inputAmount);
        if (amount <= 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_POSITIVE_MESSAGE);
        }
    }

    private static void checkPurchaseAmountIsMultipleOfThousand(String inputAmount) throws IllegalArgumentException {
        long amount = Long.parseLong(inputAmount);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND_MESSAGE);
        }
    }
}
