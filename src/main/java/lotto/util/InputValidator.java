package lotto.util;

import static lotto.constant.ErrorMessage.*;

import java.util.regex.Pattern;
import lotto.constant.ErrorMessage;

public class InputValidator {

    private final InputParser inputParser = new InputParser();
    public void validatePurchasePrice(String purchasePrice) {
        if (purchasePrice.isEmpty())
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        if (purchasePrice.matches("[-+]?\\\\d*\\\\.?\\\\d+"))
            throw new IllegalArgumentException(INVALID_PURCHASE_PRICE.getMessage());
        int validatedPurchasePrice = inputParser.parsePurchasePrice(purchasePrice);
        if (validatedPurchasePrice < 0)
            throw new IllegalArgumentException(NEGATIVE_NUMBER.getMessage());
        if (validatedPurchasePrice % 1000 != 0)
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_THOUSAND.getMessage());
    }

    public void validateWinningNumbers(String winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
        if (!isValidLottoNumbers(winningNumbers)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isValidLottoNumbers(String input) {
        String regex = "^(?:[1-9]|[1-3][0-9]|4[0-5])(,(?:[1-9]|[1-3][0-9]|4[0-5])){5}$";
        return Pattern.matches(regex, input);
    }
}
