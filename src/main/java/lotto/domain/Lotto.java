package lotto.domain;

import static lotto.common.exception.ExceptionMessages.DUPLICATED_LOTTO_NUMBER;
import static lotto.common.exception.ExceptionMessages.INVALID_LOTTO_NUMBER_COUNT;

import java.util.List;

public class Lotto {
    private final static int lottoSize = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != lottoSize) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessages());
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.getMessages());
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
