package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateLottoNumberDuplication(numbers);
        validateLottoNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT.getErrorMessage());
        }
    }

    private void validateLottoNumberDuplication(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);

        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER.getErrorMessage());
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_LOTTO_NUMBER.getErrorMessage());
            }
        }
    }


}
