package lotto.Model;

import lotto.Common.ErrorMessage;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
