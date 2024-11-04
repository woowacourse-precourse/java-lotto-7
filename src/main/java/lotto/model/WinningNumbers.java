package lotto.model;

import java.util.List;
import message.ErrorMessage;

public record WinningNumbers(List<Integer> winningNumbers) {
    private static final int WINNING_NUMBERS_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static WinningNumbers of(List<Integer> winningNumbers) {
        validateWinningNumber(winningNumbers);
        return new WinningNumbers(winningNumbers);
    }

    private static void validateWinningNumber(List<Integer> winningNumbers) {
        validateWinningNumbersCount(winningNumbers);
        validateWinningNumbersDuplicates(winningNumbers);
        validateWinningNumbersAreInRange(winningNumbers);
    }

    @Override
    public List<Integer> winningNumbers() {
        return List.copyOf(winningNumbers);
    }

    private static void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT.message());
        }
    }

    private static void validateWinningNumbersDuplicates(List<Integer> winningNumbers) {
        if (hasDuplicateNumbers(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS.message());
        }
    }

    private static void validateWinningNumbersAreInRange(List<Integer> winningNumbers) {
        if (areNumbersNotInRange(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE.message());
        }
    }

    private static boolean hasDuplicateNumbers(List<Integer> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
    }

    private static boolean areNumbersNotInRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(WinningNumbers::isNumberOutOfRange);
    }

    private static boolean isNumberOutOfRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }
}
