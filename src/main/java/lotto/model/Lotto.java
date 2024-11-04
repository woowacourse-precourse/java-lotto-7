package lotto.model;

import lotto.util.Constants;
import lotto.util.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateLange(numbers);
        validateUnique(numbers);

        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_COUNT);
        }
    }

    private void validateLange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < Constants.MIN_LOTTO_NUMBER || n > Constants.MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_LANGE);
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NOT_UNIQUE);
        }
    }
}
