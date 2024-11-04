package lotto.model;

import lotto.constant.CompareInteger;
import lotto.constant.LottoGuide;
import lotto.constant.WinningNumberRule;
import lotto.validator.NumberValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static lotto.validator.WinningNumberValidator.validateDuplication;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Comparator.naturalOrder());
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
        if (numbers.size() != CompareInteger.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(LottoGuide.ERROR.getMessage() + WinningNumberRule.COUNT.getMessage());
        }
        validateDuplication(numbers);
        for (Integer number : numbers) {
            NumberValidator.validateScope(CompareInteger.LOTTO_NUMBER_MINIMUM.getNumber(), CompareInteger.LOTTO_NUMBER_MAXIMUM.getNumber(), number, LottoGuide.ERROR.getMessage() + WinningNumberRule.SCOPE.getMessage());
        }
    }
}
