package lotto.domain.lotto;

import static lotto.infrastructure.exception.ErrorCode.*;

import java.util.List;

public class Lotto {

    private final int LOTTO_NUMBER_COUNT_CRITERION = 6;
    public final static int LOTTO_NUMBER_MINIMUM_CRITERION = 1;
    public final static int LOTTO_NUMBER_MAXIMUM_CRITERION = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateNoDuplicatedNumber(numbers);
        validateProperNumberRange(numbers);
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT_CRITERION) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNoDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT_CRITERION) {
            throw new IllegalArgumentException(INVALID_LOTTO_DUPLICATED_NUMBER.getMessage());
        }
    }

    private void validateProperNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LOTTO_NUMBER_MINIMUM_CRITERION || number > LOTTO_NUMBER_MAXIMUM_CRITERION)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
