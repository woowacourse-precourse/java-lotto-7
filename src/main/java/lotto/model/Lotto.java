package lotto.model;

import lotto.constant.LottoConstant;
import lotto.exception.LottoException;
import lotto.validation.LottoNumberValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoException.INVALID_NUMBER_COUNT.getMessage());
        }
        checkDuplicateNumbers(numbers);
    }

    private void checkDuplicateNumbers(List<Integer> numbers) {
        LottoNumberValidator.checkDuplicateNumber(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
