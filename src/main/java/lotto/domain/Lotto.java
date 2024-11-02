package lotto.domain;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.InputException;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw InputException.from(ErrorMessage.LOTTO_SIZE_IS_NOT_VALID);
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (findLottoSizeWithoutDuplicated(numbers) != LOTTO_SIZE) {
            throw InputException.from(ErrorMessage.LOTTO_NUMBER_HAS_DUPLICATED_NUMBER);
        }
    }

    private int findLottoSizeWithoutDuplicated(List<Integer> numbers) {
        return (int) numbers.stream()
                .distinct()
                .count();
    }
}
