package lotto.model;

import java.util.List;
import message.ErrorMessage;

public record WinningNumbers(List<Integer> winningNumbers) {
    private static final int WINNING_NUMBERS_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public WinningNumbers {
        validateWinningNumber(winningNumbers);
    }

    private void validateWinningNumber(List<Integer> winningNumbers) {
        validateWinningNumbersCount(winningNumbers);
        validateWinningNumbersDuplicates(winningNumbers);
        validateWinningNumbersAreInRange(winningNumbers);
    }

    @Override
    public List<Integer> winningNumbers() {
        return List.copyOf(winningNumbers);
    }

    private void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT.message());
        }
    }

    private void validateWinningNumbersDuplicates(List<Integer> winningNumbers) {
        if (hasDuplicateNumbers(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS.message());
        }
    }

    private void validateWinningNumbersAreInRange(List<Integer> winningNumbers) {
        if (areNumbersNotInRange(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE.message());
        }
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
    }

    private boolean areNumbersNotInRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isNumberOutOfRange);
    }

    private boolean isNumberOutOfRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }
}
