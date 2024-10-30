package lotto.model;

import java.util.List;

public class LottoWinningNumbers {
    private final List<Integer> WinningNumbers;
    private int bonusNumber;

    public LottoWinningNumbers(List<Integer> winningNumbers) {
        WinningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
