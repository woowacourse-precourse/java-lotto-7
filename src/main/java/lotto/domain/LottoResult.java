package lotto.domain;

import lotto.collection.WinningNumbers;
import lotto.util.Validator;

public class LottoResult {

    private final WinningNumbers winningNumbers;
    private final int bonusNumber;

    public LottoResult(WinningNumbers winningNumbers, String bonusNumber) {
        validate(winningNumbers,bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validate(WinningNumbers winningNumbers, String bonusNumber) {
        Validator.checkBonusNumber(winningNumbers,bonusNumber);
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
