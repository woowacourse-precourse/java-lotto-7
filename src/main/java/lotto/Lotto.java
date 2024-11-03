package lotto;

import lotto.enums.ErrorCode;
import lotto.enums.Value;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Integer::compareTo);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Value.lottoNumberCount) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }
        if (numbers.stream().anyMatch(number -> number < Value.lottoStartNumber || number > Value.lottoEndNumber)) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
        if (numbers.stream().distinct().count() != Value.lottoNumberCount) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }
}
