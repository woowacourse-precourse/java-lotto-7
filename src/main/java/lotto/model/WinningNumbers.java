package lotto.model;

import java.util.List;

public record WinningNumbers(List<Integer> winningNumbers) {
    public WinningNumbers {
        validateWinningNumber(winningNumbers);
    }

    private void validateWinningNumber(List<Integer> winningNumbers) {
        validateWinningNumbersCount(winningNumbers);
        validateWinningNumbersDuplicates(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
    }

    @Override
    public List<Integer> winningNumbers() {
        return List.copyOf(winningNumbers);
    }

    private void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자여야 합니다.");
        }
    }

    private void validateWinningNumbersDuplicates(List<Integer> winningNumbers) {
        if (hasDuplicateNumbers(winningNumbers)) {
            throw new IllegalArgumentException("당첨 번호에는 중복된 숫자가 있을 수 없습니다.");
        }
    }

    private void validateWinningNumbersRange(List<Integer> winningNumbers) {
        if (areNumbersNotInRange(winningNumbers)) {
            throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
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
        return number < 1 || number > 45;
    }
}
