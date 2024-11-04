package lotto.domain;

import static lotto.constant.Error.DUPLICATED_LOTTO_NUMBERS;
import static lotto.constant.Error.RANGE_LOTTO_NUMBER;
import static lotto.constant.Error.SIZE_LOTTO_NUMBERS;

import java.util.List;
import lotto.validation.NumbersValidation;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Integer::compareTo);
        this.numbers = numbers;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        NumbersValidation.validateSize(numbers, SIZE_LOTTO_NUMBERS);
        NumbersValidation.validateDuplicate(numbers, DUPLICATED_LOTTO_NUMBERS);
        NumbersValidation.validateAllRange(numbers, RANGE_LOTTO_NUMBER);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}