package lotto.lotto;

public class WinningResult {

    private final WinningNumbers winningNumbers;
    private final Number bonusNumber;

    public WinningResult(WinningNumbers winningNumbers, Number bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
