package lotto.model;

import lotto.validation.WinningNumberValidation;

import java.util.List;
import java.util.Set;

import static lotto.constants.ErrorMessage.LOTTO_NUMBER_ONLY_CAN_LENGTH_6;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ONLY_CAN_LENGTH_6.getErrorMessage());
        }
        Set<Integer> uniqueNumbers = Set.copyOf(numbers);
        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ONLY_CAN_LENGTH_6.getErrorMessage());
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
