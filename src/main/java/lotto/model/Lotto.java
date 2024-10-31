package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.constants.LottoConstants;
import lotto.validate.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < LottoConstants.LOTTO_START_INCLUSIVE
                        || number > LottoConstants.LOTTO_END_INCLUSIVE)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
