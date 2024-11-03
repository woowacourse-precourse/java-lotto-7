package lotto.domain;

import static lotto.constants.InputException.VALID_WIN_NUMBER;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_SIX = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int SAME_NUMBER_COUNT = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkNumberCount(numbers);
        checkSameNumber(numbers);
        checkNumberRange(numbers);
        this.numbers = numbers;
    }

    private void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIX) {
            throw new IllegalArgumentException(VALID_WIN_NUMBER.getMessage());
        }
    }

    private void checkSameNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (Collections.frequency(numbers, number) > SAME_NUMBER_COUNT) {
                throw new IllegalArgumentException(VALID_WIN_NUMBER.getMessage());
            }
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException(VALID_WIN_NUMBER.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
