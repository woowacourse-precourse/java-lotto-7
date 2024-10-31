package lotto;

import lotto.exception.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
        numbers.forEach(Lotto::validateNumberRange);
    }

    private static void validateNumberRange(int number) {
        if(number < 1 || number > 45){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
