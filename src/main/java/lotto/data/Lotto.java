package lotto.data;

import static lotto.config.constant.ExceptionMessageConstant.DUPLICATED_LOTTO_NUMBER;
import static lotto.config.constant.ExceptionMessageConstant.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.config.constant.ExceptionMessageConstant.INVALID_LOTTO_REQUIRED_COUNT;
import static lotto.config.constant.LottoNumberConstant.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_REQUIRED_COUNT);
        }

        if (hasIllegalRangeOfNumber(numbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER);
        }
    }

    private boolean hasIllegalRangeOfNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(MIN_NUMBER <= number && number <= MAX_NUMBER)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
