package lotto.domain;

import java.util.List;
import lotto.exception.LottoErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoErrorMessage.IS_NOT_CORRECT_COUNT.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(LottoErrorMessage.IS_NOT_POSSIBLE_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != 6) {
            throw new IllegalArgumentException(LottoErrorMessage.HAVE_DUPLICATED_NUMBER.getMessage());
        }
    }
}
