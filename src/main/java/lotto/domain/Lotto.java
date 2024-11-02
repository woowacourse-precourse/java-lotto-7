package lotto.domain;

import java.util.List;

import static lotto.exception.ErrorMessages.DUPLICATE_LOTTO_NUMBER_ERROR;
import static lotto.exception.ErrorMessages.LOTTO_NUMBER_LENGTH_ERROR;
import static lotto.util.Validator.isDuplicate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isSizeSix(numbers.size())) {
            throw new IllegalArgumentException(LOTTO_NUMBER_LENGTH_ERROR);
        }

        if (isDuplicate(numbers)){
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR);
        }
    }

    private boolean isSizeSix(int size){
        return size == 6;
    }
}
