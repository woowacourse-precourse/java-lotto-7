package lotto.model;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> numbers;

    private WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static WinningNumbers of(List<Integer> numbers) {
        return new WinningNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
    }

}
