package lotto.domain.lotto;

import lotto.exception.ExceptionMessages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicationLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessages.LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    private void validateDuplicationLottoNumbers(List<Integer> randomNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : randomNumbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ExceptionMessages.LOTTO_NUMBER_DUPLICATION_ERROR);
            }
        }
    }
}
