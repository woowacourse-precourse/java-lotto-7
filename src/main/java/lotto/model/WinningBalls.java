package lotto.model;

import java.util.List;

public class WinningBalls {

    private List<Integer> winningNumbers;

    public WinningBalls(List<Integer> winningNumbers) {
        validateSize(winningNumbers);
        validateRange(winningNumbers);
        validateDuplicate(winningNumbers);

        this.winningNumbers = winningNumbers;
    }

    private void validateDuplicate(List<Integer> winningNumbers) {
        long distinctNumber = winningNumbers.stream()
                .distinct()
                .count();
        if (distinctNumber != winningNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(this::validateRange);
    }

    private void validateRange(int number) {
        if (number < 0 || number > 46) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public int getsize() {
        return winningNumbers.size();
    }

    public boolean isDistinct(int number) {
        long duplicatingCount = winningNumbers.stream()
                .filter(num -> num == number)
                .count();

        return duplicatingCount == 0;
    }

    public int getSameNumberCount(Lotto lotto) {
        return (int) this.winningNumbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }
}
