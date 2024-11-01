package lotto.model;

import static lotto.utils.Error.DUPLICATED_LOTTO_NUMBERS;
import static lotto.utils.Error.LOTTO_NUMBERS_OUT_OF_RANGE;
import static lotto.utils.Error.NOT_SIX_LOTTO_NUMBERS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSixLottoNumbers(numbers);
        validateNoDuplicate(numbers);
        validateNumbersInRange(numbers);
    }

    private void validateSixLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_SIX_LOTTO_NUMBERS.getDescription());
        }
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS.getDescription());
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 1 || 45 < number) {
                throw new IllegalArgumentException(LOTTO_NUMBERS_OUT_OF_RANGE.getDescription());
            }
        });
    }

    @Override
    public String toString() {
        return numbers.stream().sorted().toList().toString();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
