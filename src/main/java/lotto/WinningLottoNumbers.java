package lotto;

import java.util.List;

public class WinningLottoNumbers {
    private static final int WINNING_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public WinningLottoNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbersRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
    }
}
