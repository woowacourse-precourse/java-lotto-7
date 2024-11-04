package lotto.domain;

import lotto.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        InputValidator.checkWinningNumbersContainsBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = new ArrayList<>();
        this.winningNumbers.addAll(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
