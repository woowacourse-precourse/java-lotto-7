package lotto.model;

import lotto.contants.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE.getMessage());
        }

        Set<Integer> notDuplication = new HashSet<>(numbers);
        if (notDuplication.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATION.getMessage());
        }

        for (Integer number : numbers) {
            validateLottoRange(number);
        }
    }

    private void validateLottoRange(Integer number) {
        if (number > 45) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
        }
        if (number < 1) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
