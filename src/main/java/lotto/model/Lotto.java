package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.NumberConstant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validationLottoNumbersSize(numbers);

        validationLottoNumberRange(numbers);

        validationLottoNumberDuplication(numbers);
    }

    private void validationLottoNumberDuplication(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if(numbers.size() != numbersSet.size()){
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validationLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number < LOTTO_NUMBER_MIN_RANGE || number > LOTTO_NUMBER_MAX_RANGE){
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validationLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
