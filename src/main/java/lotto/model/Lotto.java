package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import lotto.constant.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        sort(numbers);
        this.numbers = numbers;
    }

    public static Lotto generateRandomly() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto((numbers));
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateIsDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBERS_INVALID_SIZE.getMessage());
        }
    }

    private void validateIsDuplicated(final List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBERS_DUPLICATED_NUMBER.getMessage());
        }
    }

    private void validateRange(final List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isInvalidRange)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBERS_INVALID_RANGE.getMessage());
        }
    }

    private boolean isInvalidRange(final int number) {
        return number < 1 || number > 45;
    }

    private void sort(final List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
