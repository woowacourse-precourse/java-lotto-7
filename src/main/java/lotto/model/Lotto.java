package lotto.model;

import lotto.validator.WinningNumberValidator;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getMatchingCount(List<Integer> winningNumber) {
        return Math.toIntExact(numbers.stream().filter(o -> winningNumber.stream().anyMatch(Predicate.isEqual(o))).count());
    }

    public boolean isMatchBonus(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        WinningNumberValidator.validateLotto(numbers);
    }
}
