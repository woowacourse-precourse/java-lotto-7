package lotto.service;

import lotto.domain.WinningNumbers;

import java.util.List;

public class WinningNumbersService {
    public WinningNumbers getWinningNumbers (String inputWinningNumbers) {
        return new WinningNumbers(inputWinningNumbers);
    }

    public void getBonusNumber(WinningNumbers winningNumbers, String rawBonusNumber) {
        winningNumbers.getBonusNumber(rawBonusNumber);
    }
}
