package lotto.utils;

import static lotto.utils.Constant.MIN_PURCHASE_AMOUNT;
import static lotto.utils.Constant.WINNING_NUMBER_INPUT_DELIMITER;
import static lotto.utils.ErrorMessage.DELIMITER_ERROR_MESSAGE;
import static lotto.utils.ErrorMessage.EMPTY_INPUT_ERROR_MESSAGE;
import static lotto.utils.ErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE;

public class InputValidator {

    public void validateEmpty(String userInput) {
        if (userInput.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE.toString());
        }
    }

    public void validateNumber(String userInput, String errorMessage) {
        if (!userInput.matches(Constant.INTEGER_REGEX)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void validateDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT || (purchaseAmount % MIN_PURCHASE_AMOUNT != 0)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR_MESSAGE.toString());
        }
    }

    public void validateDelimiter(String userInput) {
        if (!userInput.contains(WINNING_NUMBER_INPUT_DELIMITER)) {
            throw new IllegalArgumentException(DELIMITER_ERROR_MESSAGE.toString());
        }
    }
}
