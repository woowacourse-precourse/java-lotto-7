package lotto.model;

import java.util.List;

public class LottoGame {
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    public LottoGame(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
