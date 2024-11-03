package lotto.model;

import lotto.util.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(Constants.ERROR_LOTTO_SIZE);
        }
        if (numbers.stream().distinct().count() != Constants.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(Constants.ERROR_LOTTO_DUPLICATE);
        }
        if (numbers.stream().anyMatch(number -> number < Constants.LOTTO_NUMBER_MIN || number > Constants.LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException(Constants.ERROR_LOTTO_RANGE);
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
