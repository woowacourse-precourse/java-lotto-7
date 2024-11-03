package lotto.domain.winning;

import lotto.domain.number.Number;
import lotto.domain.number.Numbers;

public class WinningInfo {
    private final Numbers winningNumbers;
    private final Number bonusNumber;

    private WinningInfo(final Numbers winningNumbers, final Number bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningInfo of(final Numbers winningNumbers, final Number bonusNumber) {
        return new WinningInfo(winningNumbers, bonusNumber);
    }

    public Numbers getWinningNumbers() {
        return winningNumbers;
    }

    public Number getBonusNumber() {
        return bonusNumber;
    }
}
