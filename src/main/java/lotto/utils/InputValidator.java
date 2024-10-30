package lotto.utils;

import static lotto.utils.Constant.MIN_PURCHASE_AMOUNT;
import static lotto.utils.Constant.WINNING_NUMBER_INPUT_DELIMITER;
import static lotto.utils.ErrorMessage.DELIMITER_ERROR_MESSAGE;
import static lotto.utils.ErrorMessage.EMPTY_INPUT_ERROR_MESSAGE;
import static lotto.utils.ErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE;

import java.util.List;

public class InputValidator {

    public int validatePurchaseAmount(String userInput) {
        validateEmpty(userInput);

        int purchaseAmount = validateNumber(userInput);
        validateDivisibleByThousand(purchaseAmount);

        return purchaseAmount;
    }

    public void validateWinningNumbers(String userInput) {
        validateEmpty(userInput);

        List<String> separatedInput = validateDelimiter(userInput);
    }

    private void validateEmpty(String userInput) {
        if (userInput.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE.toString());
        }
    }

    private int validateNumber(String userInput) {
        if (userInput.matches(Constant.INTEGER_REGEX)) {
            return Integer.parseInt(userInput);
        }

        throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR_MESSAGE.toString());
    }

    private void validateDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT || (purchaseAmount % MIN_PURCHASE_AMOUNT != 0)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR_MESSAGE.toString());
        }
    }

    private List<String> validateDelimiter(String userInput) {
        if (userInput.contains(WINNING_NUMBER_INPUT_DELIMITER)) {
            return List.of(userInput.split(WINNING_NUMBER_INPUT_DELIMITER));
        }

        throw new IllegalArgumentException(DELIMITER_ERROR_MESSAGE.toString());
    }
}
