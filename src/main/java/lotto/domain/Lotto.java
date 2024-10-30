package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.exception.CustomErrorCode;
import lotto.domain.exception.CustomException;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> displayLotto() {
        return Collections.unmodifiableList(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new CustomException(CustomErrorCode.EXCEPTION_LOTTO_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);

        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new CustomException(CustomErrorCode.EXCEPTION_DUPLICATED_LOTTO_NUMBER);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER)) {
            throw new CustomException(CustomErrorCode.EXCEPTION_LOTTO_RANGE);
        }
    }
}
