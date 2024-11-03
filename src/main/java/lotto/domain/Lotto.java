package lotto.domain;

import static lotto.constants.LottoConstants.LOWER_BOUND;
import static lotto.constants.LottoConstants.NUMBERS_PER_LOTTO;
import static lotto.constants.LottoConstants.UPPER_BOUND;
import static lotto.exception.ErrorMessages.NUMBER_COUNT_MISMATCH;
import static lotto.exception.ErrorMessages.NUMBER_DUPLICATION;
import static lotto.exception.ErrorMessages.OUT_OF_RANGE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers ) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersCount(numbers);
        for (Integer number : numbers) {
            validateEachLottoNumber(number);
        }
        validateNoDuplication(numbers);
    }
    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6 ){
            throw new IllegalArgumentException(String.format(NUMBER_COUNT_MISMATCH.getMessage(),NUMBERS_PER_LOTTO.getValue()));
        }
    }

    private void validateEachLottoNumber(Integer number) {
        if (number < LOWER_BOUND.getValue() || number > UPPER_BOUND.getValue()) {
            throw new IllegalArgumentException(String.format(OUT_OF_RANGE.getMessage(), LOWER_BOUND.getValue(),UPPER_BOUND.getValue()));
        }
    }

    private void validateNoDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(NUMBER_DUPLICATION.getMessage());
        }
    }



}
