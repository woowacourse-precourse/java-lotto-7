package lotto.domain;

import lotto.exception.lotto.LottoNumberDuplicateException;
import lotto.exception.lotto.LottoNumberRangeException;
import lotto.exception.lotto.LottoNumberSizeException;
import lotto.util.Limit;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Limit.LOTTO_SIZE) {
            throw new LottoNumberSizeException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number >= Limit.MIN_RANGE && number <= Limit.MAX_RANGE)) {
            throw new LottoNumberRangeException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new LottoNumberDuplicateException();
        }
    }

    public String getSortedLottoString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Integer::compareTo);
        return sortedNumbers.toString();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }
}
