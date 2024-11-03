package lotto.utils.validator;

import static lotto.utils.Constant.MAX_LOTTO_NUMBER;
import static lotto.utils.Constant.MAX_LOTTO_NUMBER_COUNT;
import static lotto.utils.Constant.MIN_LOTTO_NUMBER;
import static lotto.utils.Constant.WINNING_NUMBER_INPUT_DELIMITER;
import static lotto.utils.ErrorMessage.DELIMITER_ERROR_MESSAGE;
import static lotto.utils.ErrorMessage.WINNING_NUMBER_COUNT_ERROR_MESSAGE;
import static lotto.utils.ErrorMessage.WINNING_NUMBER_ERROR_MESSAGE;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberValidator extends Validator {

    @Override
    public void validate(String userInput) {
        validateEmpty(userInput);
        validateContainDelimiter(userInput);
    }

    private void validateContainDelimiter(String userInput) {
        if (hasNotDelimiter(userInput)) {
            throw new IllegalArgumentException(DELIMITER_ERROR_MESSAGE.toString());
        }
    }

    private boolean hasNotDelimiter(String userInput) {
        return !userInput.contains(WINNING_NUMBER_INPUT_DELIMITER);
    }

    public void validateNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != MAX_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(WINNING_NUMBER_COUNT_ERROR_MESSAGE.toString());
        }
    }

    public void validateNumbersInRange(List<Integer> winningNumbers) {
        if (Collections.min(winningNumbers) < MIN_LOTTO_NUMBER || Collections.max(winningNumbers) > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(WINNING_NUMBER_ERROR_MESSAGE.toString());
        }
    }

    public void validateDuplicateNumber(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);

        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_ERROR_MESSAGE.toString());
        }
    }
}
