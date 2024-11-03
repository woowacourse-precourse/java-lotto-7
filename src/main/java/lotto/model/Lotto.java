package lotto.model;

import lotto.utility.ExceptionEnum;

import java.util.List;

public class Lotto {
    private static final int REQUIRED_NUMBERS_LENGTH = 6;
    private static final int MIN_NUMBER = 1;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUnderZero(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUnderZero(List<Integer> numbers) {
        boolean hasZero = numbers.stream()
                .anyMatch(num -> num < MIN_NUMBER);

        if (hasZero) {
            throw new IllegalArgumentException(ExceptionEnum.CANNOT_INCLUDE_ZERO.getMessage());
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
