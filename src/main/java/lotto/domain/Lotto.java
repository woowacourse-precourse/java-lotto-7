package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.exception.InvalidInputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int matchCount(WinningNumbers winningNumbers) {
        long matchCount = numbers.stream()
                .filter(winningNumbers.getWinningNumbers()::contains)
                .count();
        return (int) matchCount;
    }

    public boolean hasBonusNumber(WinningNumbers winningNumbers) {
        return numbers.contains(winningNumbers.getBonusNumber());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || new HashSet<>(numbers).size() != 6) {
            throw new InvalidInputException(InvalidInputException.DUPLICATED_INPUT_ERROR);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
