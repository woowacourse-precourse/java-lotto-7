package lotto.model;

import static lotto.constants.LottoConfig.NUMBERS_SIZE;
import static lotto.constants.LottoConfig.NUMBER_RANGE_MAXIMUM;
import static lotto.constants.LottoConfig.NUMBER_RANGE_MINIMUM;

import java.util.List;
import java.util.Objects;
import lotto.constants.ExceptionMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        if (hasTooManyNumbers(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_TOO_MANY_NUMBERS.getMessage());
        }
        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_DUPLICATE_NUMBER.getMessage());
        }
        if (hasOutOfRangeNumber(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    private boolean hasTooManyNumbers(List<Integer> numbers) {
        return numbers.size() != NUMBERS_SIZE;
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean hasOutOfRangeNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(int number) {
        return number < NUMBER_RANGE_MINIMUM || number > NUMBER_RANGE_MAXIMUM;
    }

    public int countMatchingNumbers(Lotto lotto) {
        return (int) this.numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
    }

    public boolean containsBonusNumber(BonusNumber bonusNumber) {
        return bonusNumber.matches(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto lotto)) {
            return false;
        }
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }
}
