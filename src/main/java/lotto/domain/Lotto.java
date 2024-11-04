package lotto.domain;

import lotto.exception.LottoArgumentException;
import lotto.exception.LottoErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.validation.LottoNumbersValidation.isValidateLottoNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidateLottoNumbers(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        numbers.sort(Integer::compareTo);
        return numbers.toString();
    }
}
