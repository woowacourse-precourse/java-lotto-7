package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static lotto.global.enums.PrintMessage.*;

public class WinningNumbers {
    private final List<Integer> winningNumber;
    private final Integer bonusNumber;

    public WinningNumbers(List<Integer> winningNumber, Integer bonusNumber) {
        validate(winningNumber, bonusNumber);
        this.winningNumber = sortNumbers(winningNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_COUNT.getMessage());
        }

        boolean flag = winningNumbers.stream().allMatch(this::validateRange);
        if (!flag || !validateRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }

        HashSet<Integer> set = new HashSet<>(winningNumbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException(NOT_ALLOWED_DUPLICATE_WINNING_NUMBER.getMessage());
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(NOT_ALLOWED_DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    private boolean validateRange(Integer num) {
        return 1 <= num && num <= 45;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public List<Integer> getWinningNumber() {
        return Collections.unmodifiableList(winningNumber);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
