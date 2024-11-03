package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validatePositive(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> setNumbers = new HashSet<>(numbers);
        if (setNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER_NOT_ALLOWED.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validatePositive(List<Integer> numbers) {
        for (int number : numbers) {
            if (number <= 0) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_LOTTO_NUMBER_NOT_ALLOWED.getMessage());
            }
        }
    }
}
