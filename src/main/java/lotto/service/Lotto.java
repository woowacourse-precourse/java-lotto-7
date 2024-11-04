package lotto.service;

import static lotto.view.exception.ErrorMessage.validateLottoNumberCount;
import static lotto.view.exception.ErrorMessage.validateLottoNumberDuplicate;
import static lotto.view.exception.ErrorMessage.validateLottoNumberRange;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateLottoNumberRange(numbers);
        validateLottoNumberDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(validateLottoNumberCount);
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers){
        for(int number : numbers){
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(validateLottoNumberRange);
            }
        }
    }

    private void validateLottoNumberDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(validateLottoNumberDuplicate);
        }
    }


    public List<Integer> getWinningLottoNumbers() {
        return numbers;
    }
}
