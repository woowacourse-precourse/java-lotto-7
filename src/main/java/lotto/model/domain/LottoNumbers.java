package lotto.model.domain;

import java.util.List;
import lotto.model.ErrorMessage;

public class LottoNumbers {

    private List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers;
    }

    private void validateDuplicate(List<Integer> numbers) {
        long distinctNumber = numbers.stream()
                .distinct()
                .count();
        if (distinctNumber != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(this::validateRange);
    }

    private void validateRange(int number) {
        if (number < 0 || number > 46) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
