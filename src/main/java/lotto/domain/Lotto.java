package lotto.domain;

import java.util.List;

import static lotto.constants.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        numberCountValidate(numbers);
        overlapValidate(numbers);
    }

    private void numberCountValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR + WINNING_NUMBER_SIZE_SIX);
        }
    }

    private void overlapValidate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR + WINNING_NUMBER_NO_DUPLICATE);
        }
    }

    public void setBonusNumber(int bonusNumber) {
        bonusNumberValidate(bonusNumber);
        numbers.add(bonusNumber);
    }

    private void bonusNumberValidate(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR + BONUS_AND_WINNING_NUMBER_NO_DUPLICATE_);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
