package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ErrorMessage;

public class WinningNumber {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_EXCEED);
        }

        if (isDuplication(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS);
        }
    }

    private boolean isDuplication(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (numbers.size() != distinctNumbers.size()) {
            return true;
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
