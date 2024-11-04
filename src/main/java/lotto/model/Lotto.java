package lotto.model;

import static lotto.Constants.MAX_NUMBER;
import static lotto.Constants.MIN_NUMBER;
import static lotto.ErrorConstants.ERROR_DUPLICATE_NUMBERS_NOT_ALLOWED;
import static lotto.ErrorConstants.ERROR_LOTTO_NUMBERS_SIZE;
import static lotto.ErrorConstants.ERROR_NUMBER_RANGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersRange(numbers);
        validateDuplication(numbers);
        this.numbers = getSorted(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> getSorted(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>(numbers);
        Collections.sort(result);
        return result;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBERS_SIZE);
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(this::checkNumberRange);
    }

    private void checkNumberRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS_NOT_ALLOWED);
        }
    }
}
