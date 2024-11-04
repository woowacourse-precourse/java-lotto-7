package lotto.service;

import lotto.model.WinningNumbers;
import lotto.validator.WinningNumbersValidator;

import java.util.List;

public class WinningNumbersService {

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        WinningNumbersValidator.validateWinningNumbers(winningNumbers);
    }

    public void validateBonusNumber(List<Integer> winingNumbers, int bonusNumber) {
        WinningNumbersValidator.validateBonusNumber(winingNumbers, bonusNumber);
    }

    public WinningNumbers generateWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }
}
