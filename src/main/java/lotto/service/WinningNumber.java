package lotto.service;

import lotto.constants.ErrorMessages;

import java.util.HashSet;
import java.util.List;

public class WinningNumber {
    private static final Integer WINNING_NUMBERS_COUNT=6;
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        validateNull(numbers);
        validateWinningNumbersCount(numbers);
        validateWinningNumbersDuplicates(numbers);
        validateWinningNumbersRange(numbers);
    }

    private void validateNull(List<Integer> numbers) {
        if(numbers==null){
            throw new IllegalArgumentException(ErrorMessages.INPUT_MUST_BE_NUMBER);
        }
    }

    private void validateWinningNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (1 > number || number > 45) {
                throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
            }
        }
    }

    private void validateWinningNumbersCount(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_WINNING_NUMBER_COUNT_INVALID);
        }
    }

    private void validateWinningNumbersDuplicates(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_DUPLICATE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
