package lotto.domain;

import java.util.HashSet;
import lotto.domain.vo.Number;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = convertIntegerToNumber(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw LottoException.from(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT_ERROR);
        }

        if (new HashSet<>(numbers).size() != LOTTO_NUMBER_COUNT) {
            throw LottoException.from(ErrorMessage.DUPLICATE_LOTTO_NUMBERS_ERROR);
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    private List<Number> convertIntegerToNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(Number::newInstance)
                .toList();
    }
}
