package lotto.domain.model;

import java.util.List;
import java.util.stream.Collectors;

//당첨 번호, 보너스 번호 관리 클래스
public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber); // 유효성 검사
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
        this.bonusNumber = bonusNumber;
    }

    //당첨 번호, 보너스 번호 유효성 검사 메서드
    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_INPUT.getMessage());
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_WINNING_NUMBER_ERROR.getMessage());
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
        }
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45) || bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.getNumbers().stream().filter(numbers::contains).count();
    }

    public boolean isBonusMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
