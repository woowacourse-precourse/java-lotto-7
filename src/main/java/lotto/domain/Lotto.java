package lotto.domain;

import lotto.exception.LottoNumberDuplicateException;
import lotto.exception.LottoNumberRangeException;
import lotto.exception.LottoNumberSIzeException;

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
        if (numbers.size() != 6) {
            throw new LottoNumberSIzeException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number >= 1 && number <= 45)) {
            throw new LottoNumberRangeException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new LottoNumberDuplicateException();
        }
    }

    public String getLottoString() {
        numbers.sort(Integer::compareTo);
        return numbers.toString();
    }
}
