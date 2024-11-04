package lotto.domain;

import lotto.ErrorCode;

import java.util.Arrays;
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
        validateLottoNumberLengthIsSix(numbers);
        validateLottoNumberIsDuplicate(numbers);
    }

    private void validateLottoNumberLengthIsSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_COUNT.getErrorMessage());
        }
    }

    private void validateLottoNumberIsDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicates = new HashSet<>(numbers);
        if(checkDuplicates.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_DUPLICATE.getErrorMessage());
        }
    }

    public Integer howManyMatches(WinningNumber winningNumber) {
        Integer count = 0;
        for (Integer number : numbers) {
            if (winningNumber.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.stream().sorted().toArray());
    }
}
