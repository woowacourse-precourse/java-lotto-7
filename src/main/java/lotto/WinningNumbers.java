package lotto;

import java.util.List;

public class WinningNumbers {

    private static final int NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateNumberCount(numbers);
        this.numbers = numbers;
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
