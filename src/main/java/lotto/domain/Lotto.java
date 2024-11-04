package lotto.domain;

import static lotto.constant.NumberType.LOTTO_COUNT;
import static lotto.constant.NumberType.LOTTO_MAX_NUMBER;
import static lotto.constant.NumberType.LOTTO_MIN_NUMBER;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_COUNTS;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_DUPLICATE;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_RANGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT.getNumber()) {
            throw new LottoException(INVALID_LOTTO_COUNTS);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                throw new LottoException(INVALID_LOTTO_DUPLICATE);
            }
        }
        ;
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_MIN_NUMBER.getNumber() || number > LOTTO_MAX_NUMBER.getNumber()) {
                throw new LottoException(INVALID_LOTTO_RANGE);
            }
        }
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> numbers = new ArrayList<>(this.numbers);
        Collections.sort(numbers);
        return numbers;
    }
}
