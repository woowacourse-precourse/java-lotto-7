package lotto.domain;

import static lotto.constans.ErrorMessages.ERROR_DUPLICATE_NUMBERS;
import static lotto.constans.ErrorMessages.ERROR_INVALID_COUNT;
import static lotto.constans.ErrorMessages.ERROR_INVALID_RANGE;
import static lotto.constans.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constans.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.constans.LottoConstants.REQUIRED_LOTTO_NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbersWithinRange(numbers);
        validateLottoNumberCount(numbers);
        validateNoDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto::containsNumber)
                .count();
    }

    private void validateLottoNumbersWithinRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ERROR_INVALID_RANGE);
            }
        }
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_INVALID_COUNT);
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS);
        }
    }
}
