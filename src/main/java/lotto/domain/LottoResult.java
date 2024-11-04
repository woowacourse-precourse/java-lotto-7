package lotto.domain;

import lotto.collection.WinningNumber;
import lotto.util.Validator;

public class LottoResult {

    private final WinningNumber winningNumbers;
    private final int bonusNumber;

    public LottoResult(WinningNumber winningNumbers, String bonusNumber) {
        validate(winningNumbers,bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validate(WinningNumber winningNumbers, String bonusNumber) {
        Validator.checkBonusNumber(winningNumbers,bonusNumber);
    }

    public WinningNumber getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
