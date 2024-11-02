package lotto.model;

import lotto.vo.BonusNumber;
import lotto.vo.MainNumber;

public class WinningNumber {
    private final MainNumber mainNumber;
    private final BonusNumber bonusNumber;


    public WinningNumber(MainNumber mainNumber, BonusNumber bonusNumber) {
        this.mainNumber = mainNumber;
        this.bonusNumber = bonusNumber;
    }
}
