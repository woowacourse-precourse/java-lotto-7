package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.global.string.ErrorConstants;

public class Lotto {
    private final List<Integer> numbers;
    private Integer bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        IsNumberDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorConstants.VALIDATE_NUMBER_MSG);
        }
    }

    private void IsNumberDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorConstants.DUPLICATE_NUMBER_ERROR_MSG + number);
            }
        }
    }
}
