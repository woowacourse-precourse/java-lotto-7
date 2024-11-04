package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersRange(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LottoOption.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_LENGTH);
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoOption.MIN_LOTTO_NUMBER || LottoOption.MAX_LOTTO_NUMBER < number) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
            }
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();

        for (Integer number : numbers) {
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBERS);
            }
        }
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public int getMatchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }
}
