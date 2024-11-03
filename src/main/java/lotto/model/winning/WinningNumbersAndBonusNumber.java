package lotto.model.winning;

import java.util.List;

public class WinningNumbersAndBonusNumber {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbersAndBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new WinningNumbers(winningNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

}
