package lotto.model.domain;

import lotto.exception.LottoErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
