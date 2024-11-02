package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.message.ErrorMessage.*;

public class Lotto {

    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.message());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO.message());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(LottoNumberRange::excludeRange)) {
            throw new IllegalArgumentException(EXCLUDE_LOTTO_RANGE.message());
        }
    }
}
