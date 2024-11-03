package lotto.model;

import lotto.utility.ExceptionEnum;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateUnderZero(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUnderZero(List<Integer> numbers) {
        boolean hasZero = numbers.stream()
                .anyMatch(num -> num <= 0);

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
