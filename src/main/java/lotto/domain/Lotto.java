package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import lotto.exception.InvalidLottoNumberRangeException;
import lotto.exception.InvalidLottoNumbersDuplicateException;
import lotto.exception.InvalidLottoNumbersSizeException;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final Integer LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = createSortedNumbers(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private List<Integer> createSortedNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(List.copyOf(numbers));
        Collections.sort(sortedNumbers);
        return Collections.unmodifiableList(sortedNumbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new InvalidLottoNumbersSizeException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new InvalidLottoNumbersDuplicateException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::validateRange);
    }

    private void validateRange(Integer number) {
        if (!(MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER)) {
            throw new InvalidLottoNumberRangeException();
        }
    }

    public int getMatchLottoNumber(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::isContain)
                .count();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }
}
