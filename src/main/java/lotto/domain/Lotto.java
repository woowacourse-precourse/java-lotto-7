package lotto.domain;

import static lotto.exception.Exception.DUPLICATED_LOTTO_NUMBERS;
import static lotto.exception.Exception.INVALID_LOTTO_NUMBERS_COUNT;
import static lotto.exception.Exception.LOTTO_NUMBERS_OUT_OF_RANGE;
import static lotto.utils.Constants.LOTTO_NUMBERS_SIZE;

import java.util.List;
import lotto.utils.LottoNumberValidator;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNoDuplicateNumbers(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_COUNT.getMessage());
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        if (!containsNoDuplicates(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS.getMessage());
        }
    }

    private boolean containsNoDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (!isWithinRange(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isWithinRange(List<Integer> numbers) {
        return numbers.stream().allMatch(LottoNumberValidator::isWithinRange);
    }
}
