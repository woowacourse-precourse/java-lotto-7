package lotto.data;

import lotto.constants.ErrorCode;
import lotto.constants.Value;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
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

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
