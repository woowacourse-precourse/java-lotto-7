package lotto;

import java.util.List;

public class WinningNumbers {

    private static final int NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateNumberDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 0 || number > 46) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateNumberDuplication(List<Integer> numbers) {
        for (int number : numbers) {
            if (numbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되어서는 안됩니다.");
            }
        }
    }
}
