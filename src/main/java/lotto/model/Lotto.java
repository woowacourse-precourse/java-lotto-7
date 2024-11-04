package lotto.model;

import lotto.enumerate.ExceptionEnum;
import lotto.utility.ExceptionThrower;

import java.util.List;

public class Lotto {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionThrower.throwing(ExceptionEnum.LOTTO_MUST_BE_SIX);
        }
    }

    private void validateSize(List<Integer> numbers) {
        boolean hasZero = numbers.stream()
                .anyMatch(num -> num < MIN_NUMBER);
        if (hasZero) {
            ExceptionThrower.throwing(ExceptionEnum.CANNOT_INCLUDE_ZERO);
        }

        boolean overFourtyFive = numbers.stream()
                .anyMatch(num -> num > MAX_LOTTO_NUMBER);
        if (overFourtyFive) {
            ExceptionThrower.throwing(ExceptionEnum.CANNOT_OVER_FOURTY_SIX);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long uniqueCount = numbers.stream()
                .distinct()
                .count();

        if (uniqueCount != numbers.size()) {
            ExceptionThrower.throwing(ExceptionEnum.CANNOT_DRAW_DUPLICATE_NUMBER);
        }
    }

    public long getMatchedNumbersCount(List<Integer> winningNumbers) {
        return numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean checkBonusNumberMathced(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
