package lotto.validation;

import lotto.enums.LottoErrorMessage;
import lotto.exception.LottoException;

public class LottoPurchaseValidation {
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100000;

    public static int validatePurchaseAmount(String input) {
        validateEmptyOrBlank(input);
        validateNumericInput(input);
        int purchaseAmount = parsePurchaseAmount(input);
        validate(purchaseAmount);
        return purchaseAmount;
    }

    private static void validateNumericInput(String input) {
        if (!input.matches("\\d+")) {
            throw new LottoException(LottoErrorMessage.NON_NUMERIC_INPUT);
        }
    }

    private static void validate(int purchaseAmount) {
        validateMinimumPurchaseAmount(purchaseAmount);
        validateMaximumPurchaseAmount(purchaseAmount);
        validateMultipleOfMinimum(purchaseAmount);
    }

    private static int parsePurchaseAmount(String purchaseAmountInput) {
        validateEmptyOrBlank(purchaseAmountInput);
        return Integer.parseInt(purchaseAmountInput);
    }

    private static void validateEmptyOrBlank(String purchaseAmountInput) {
        if (purchaseAmountInput.strip().isBlank()) {
            throw new LottoException(LottoErrorMessage.EMPTY_OR_BLANK_INPUT);
        }
    }

    private static void validateMinimumPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT) {
            throw new LottoException(LottoErrorMessage.BELOW_MINIMUM_PURCHASE_AMOUNT);
        }
    }

    private static void validateMaximumPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount > MAX_PURCHASE_AMOUNT) {
            throw new LottoException(LottoErrorMessage.EXCEEDS_MAX_PURCHASE_AMOUNT);
        }
    }

    private static void validateMultipleOfMinimum(int purchaseAmount) {
        if (purchaseAmount % MIN_PURCHASE_AMOUNT != 0) {
            throw new LottoException(LottoErrorMessage.INVALID_PURCHASE_AMOUNT);
        }
    }
}