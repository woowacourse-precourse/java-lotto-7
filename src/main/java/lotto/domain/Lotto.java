package lotto.domain;

import static lotto.constants.Constants.LOTTO_MAX;
import static lotto.constants.Constants.LOTTO_MIN;
import static lotto.constants.Constants.LOTTO_SIZE;
import static lotto.utils.NumberValidator.validateNumberRange;

import java.util.List;
import java.util.function.Predicate;
import lotto.constants.ErrorMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public int countDuplication(Lotto lotto) {
        return numbers.stream()
                .filter(x -> lotto.getSortedLotto().stream()
                        .anyMatch(Predicate.isEqual(x)))
                .toList().size();
    }

    public List<Integer> getSortedLotto() {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        numbers.forEach(number -> validateNumberRange(number, LOTTO_MIN, LOTTO_MAX));
        validateCount(numbers);
        validateDuplication(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_COUNT.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_DUPLICATED.getMessage());
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }
}
