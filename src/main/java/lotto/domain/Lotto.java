package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.constants.ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.constants.ExceptionMessage.LOTTO_NUMBER_NOT_EMPTY;
import static lotto.constants.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.constants.LottoConstants.MIN_NUMBER;
import static lotto.constants.LottoConstants.MAX_NUMBER;
import static lotto.constants.LottoConstants.NUMBER_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateNull(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT);
        }
    }
    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
            }
        }
    }
    private void validateNull(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NOT_EMPTY);
        }
    }
    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers () {
        return numbers;
    }
    public List<Integer> getSortNumbers () {
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        sortNumbers.sort(Integer::compareTo);
        return sortNumbers;
    }
}
