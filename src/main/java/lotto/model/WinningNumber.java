package lotto.model;

import lotto.exception.InvalidWinningNumbersException;

import java.util.ArrayList;
import java.util.List;

import static lotto.exception.ErrorMessage.DUPLICATE_NUMBER_IS_NOT_ALLOWED;
import static lotto.exception.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.exception.ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT;
import static lotto.model.Lotto.MAX_LOTTO_NUMBER;
import static lotto.model.Lotto.MIN_LOTTO_NUMBER;

public class WinningNumber {
    private List<Integer> winningNumber;

    public WinningNumber(String input) {
        convertInputToWinningNumber(input);
    }

    public List<Integer> get() {
        return winningNumber;
    }

    private void convertInputToWinningNumber(String input) {
        checkHasValidInputFormat(input);
        List<Integer> createdLotto = processingWinningNumber(input);
        checkEachNumberHasValidate(createdLotto);

        winningNumber = createdLotto;
    }

    private void checkHasValidInputFormat(String input) {
        if (!input.matches("^-?\\d+(,-?\\d+){5}")) {
            throw new InvalidWinningNumbersException(INVALID_WINNING_NUMBERS_FORMAT.getMessage());
        }
    }

    private List<Integer> processingWinningNumber(String input) {
        List<String> splitInputByComma = List.of(input.split(","));
        List<Integer> processedWinningNumber = new ArrayList<>();

        for (String string : splitInputByComma) {
            processedWinningNumber.add(Integer.parseInt(string.trim()));
        }

        return processedWinningNumber;
    }

    private void checkEachNumberHasValidate(List<Integer> winningNumber) {
        checkNumberHasDuplicate(winningNumber);
        checkEachNumberHasValidRange(winningNumber);
    }

    private void checkEachNumberHasValidRange(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new InvalidWinningNumbersException(INVALID_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void checkNumberHasDuplicate(List<Integer> winningNumber) {
        if (winningNumber.size() != winningNumber.stream().distinct().count()) {
            throw new InvalidWinningNumbersException(DUPLICATE_NUMBER_IS_NOT_ALLOWED.getMessage());
        }
    }
}
