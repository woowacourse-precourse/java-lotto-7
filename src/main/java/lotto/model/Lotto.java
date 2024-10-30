package lotto.model;

import static lotto.utils.Constants.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.utils.Constants;
import lotto.utils.ErrorMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String getFormattedNumbers() {
        return numbers.toString();
    }

    private void sortNumbers() {
        numbers.sort(Integer::compareTo);
    }

    private void validate(List<Integer> numbers) {
        checkLottoNumbersSize(numbers);
        checkLottoNumberIsDuplicate(numbers);
        checkLottoNumberRange(numbers);
    }

    private void checkLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_COUNT);
        }
    }

    private void checkLottoNumberIsDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_LOTTO_NUMBERS);
        }
    }

    private void checkLottoNumberRange(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ErrorMessages.OUT_OF_BOUNDS_LOTTO_NUMBER);
            }
        }
    }
}
