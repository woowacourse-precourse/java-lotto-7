package lotto.model;

import lotto.utility.ExceptionEnum;

import java.util.List;

public class Lotto {
    private static final int REQUIRED_NUMBERS_LENGTH = 6;
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
        if (numbers.size() != REQUIRED_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        boolean hasZero = numbers.stream()
                .anyMatch(num -> num < MIN_NUMBER);
        if (hasZero) {
            throw new IllegalArgumentException(ExceptionEnum.CANNOT_INCLUDE_ZERO.getMessage());
        }

        boolean overFourtyFive = numbers.stream()
                .anyMatch(num -> num > MAX_LOTTO_NUMBER);
        if (overFourtyFive) {
            throw new IllegalArgumentException(ExceptionEnum.CANNOT_OVER_FOURTY_SIX.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long uniqueCount = numbers.stream()
                .distinct()
                .count();

        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException(ExceptionEnum.CANNOT_DRAW_DUPLICATE_NUMBER.getMessage());
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
