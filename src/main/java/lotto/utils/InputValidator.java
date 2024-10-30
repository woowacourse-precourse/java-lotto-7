package lotto.utils;

import static lotto.utils.Constant.MAX_LOTTO_NUMBER;
import static lotto.utils.Constant.MAX_LOTTO_NUMBER_COUNT;
import static lotto.utils.Constant.MIN_LOTTO_NUMBER;
import static lotto.utils.Constant.MIN_PURCHASE_AMOUNT;
import static lotto.utils.Constant.WINNING_NUMBER_INPUT_DELIMITER;
import static lotto.utils.ErrorMessage.DELIMITER_ERROR_MESSAGE;
import static lotto.utils.ErrorMessage.EMPTY_INPUT_ERROR_MESSAGE;
import static lotto.utils.ErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE;
import static lotto.utils.ErrorMessage.WINNING_NUMBER_COUNT_ERROR_MESSAGE;
import static lotto.utils.ErrorMessage.WINNING_NUMBER_DUPLICATE_ERROR_MESSAGE;
import static lotto.utils.ErrorMessage.WINNING_NUMBER_RANGE_ERROR_MESSAGE;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void validateNumberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != MAX_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(WINNING_NUMBER_COUNT_ERROR_MESSAGE.toString());
        }
    }

    public void validateNumberRange(List<Integer> winningNumbers) {
        if (Collections.min(winningNumbers) < MIN_LOTTO_NUMBER || Collections.max(winningNumbers) > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE_ERROR_MESSAGE.toString());
        }
    }

    public void validateDuplicateNumber(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);

        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE_ERROR_MESSAGE.toString());
        }
    }
}
