package lotto.model;

import static lotto.message.ErrorMessage.LOTTO_SIZE_6;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_6.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
