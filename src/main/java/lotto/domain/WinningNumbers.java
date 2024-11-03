package lotto.domain;

import lotto.validator.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;

        validate(winningNumbers, bonusNumber);
    }

    private static void validate(List<Integer> winninNumbers, int bonusNumber) {
        Set<Integer> allNumbers = new HashSet<>(winninNumbers);
        allNumbers.add(bonusNumber);

        Validator.validateAllNumber(allNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
