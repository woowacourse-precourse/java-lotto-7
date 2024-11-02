package lotto.vo;

import java.util.List;

public class MainNumber {
    private final List<Integer> numbers;

    public MainNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            // TODO: 에러 발생
        }
    }

    // TODO: 추가 기능 구현
}
