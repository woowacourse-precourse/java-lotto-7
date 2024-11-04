package lotto.input;

import static lotto.constants.ErrorMessage.LOTTO_DUPLICATION_ERROR;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        validate(numbers);
        validateDuplication(numbers);

        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> duplicate = new HashSet<>(numbers);
        if (duplicate.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION_ERROR.getMessage());
        }
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getMessage());
            }
        }
    }
}
