package lotto.domain;

import static lotto.constant.ApplicationConstants.LOTTO_NUMBER_COUNT;
import static lotto.constant.ApplicationConstants.LOTTO_RANGE_MAX;
import static lotto.constant.ApplicationConstants.LOTTO_RANGE_MIN;

import java.util.List;
import lotto.enums.ErrorMessage;

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
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_RANGE_MIN || number > LOTTO_RANGE_MAX) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int uniqueCount = (int) numbers.stream().distinct().count();
        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

}
