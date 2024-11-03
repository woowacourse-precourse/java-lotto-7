package lotto.domain;

import static lotto.common.config.Constants.LOTTO_NUMBERS_COUNT;
import static lotto.common.config.Constants.MAX_NUMBER;
import static lotto.common.config.Constants.MIN_NUMBER;
import static lotto.common.exception.ExceptionMessages.DUPLICATED_LOTTO_NUMBER;
import static lotto.common.exception.ExceptionMessages.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.common.exception.ExceptionMessages.OUT_OF_LOTTO_NUMBER_RANGE;

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
        if (numbers.size() != LOTTO_NUMBERS_COUNT.getNumber()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessages());
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.getMessages());
        }
        if (!areNumbersInLottoRange(numbers)) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_NUMBER_RANGE.getMessages());
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean areNumbersInLottoRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number >= MIN_NUMBER.getNumber() && number <= MAX_NUMBER.getNumber());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public long countMatchNumbers(Lotto otherLotto) {
        Set<Integer> otherNumbers = new HashSet<>(otherLotto.numbers);
        return this.numbers.stream()
                .filter(otherNumbers::contains)
                .count();
    }
}
