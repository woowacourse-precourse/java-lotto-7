package lotto.model;

import lotto.message.LottoErrorMessage;

import java.util.List;

public class Lotto {
    private static final int MAX_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != MAX_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_NUMBER_COUNT.getMessage());
        }
        if (numbers.stream().anyMatch(num -> num < LOTTO_MIN_NUMBER || num > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
