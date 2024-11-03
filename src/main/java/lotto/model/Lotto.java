package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.constant.Rule;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        sort(numbers);
        this.numbers = numbers;
    }

    public static Lotto generateRandomly() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Rule.MIN_LOTTO_NUMBER,
                Rule.MAX_LOTTO_NUMBER,
                Rule.LOTTO_NUMBERS_COUNT
        );
        return new Lotto((numbers));
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateIsDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != Rule.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBERS_INVALID_SIZE.getMessage());
        }
    }

    private void validateIsDuplicated(final List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != Rule.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBERS_DUPLICATED_NUMBER.getMessage());
        }
    }

    private void validateRange(final List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isInvalidRange)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBERS_INVALID_RANGE.getMessage());
        }
    }

    private boolean isInvalidRange(final int number) {
        return number < Rule.MIN_LOTTO_NUMBER || number > Rule.MAX_LOTTO_NUMBER;
    }

    private void sort(final List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
