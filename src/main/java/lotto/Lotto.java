package lotto;

import lotto.common.ExceptionMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionMessage.INVALID_COUNT_NUMBERS.printException();
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            ExceptionMessage.NUMBER_DUPLICATED.printException();
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
