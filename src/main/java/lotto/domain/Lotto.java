package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.common.Constants.*;
import static lotto.common.ValidationUtils.validateDuplicate;
import static lotto.common.ValidationUtils.validateSize;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
        sortDesc();
    }

    public boolean containBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        int matchingCount = 0;

        for (Integer number: numbers) {
            if (winningNumbers.contains(number)) {
                matchingCount ++;
            }
        }

        return matchingCount;
    }

    public Integer size () {
        return numbers.size();
    }

    public boolean compare(List<Integer> numbers) {
        if (numbers == null) {
            return false;
        }

        return this.numbers.equals(numbers);
    }

    @Override
    public String toString () {
        List<String> numbersToString = numbers.stream()
                .map(String::valueOf)
                .toList();

        return String.join(LOTTO_NUMBER_PRINT_DELIMITER, numbersToString);
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        validateSize(numbers, LOTTO_SIZE, INVALID_LOTTO_SIZE);
        validateDuplicate(numbers, INVALID_DUPLICATE_LOTTO);
    }

    private void sortDesc () {
        Collections.sort(numbers);
    }
}
