package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.TOO_MANY_NUMBERS.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public Long checkMatchCount(List<Integer> checkingNumbers) {
        return numbers.stream()
                .filter(checkingNumbers::contains)
                .count();
    }

    public boolean checkBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
