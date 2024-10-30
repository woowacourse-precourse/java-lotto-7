package lotto.domain;

import static lotto.constant.ErrorMessage.NUMBER_COUNT_ERROR;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void sortLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
