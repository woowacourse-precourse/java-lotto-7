package lotto.domain.number;

import lotto.domain.lottoForm.WinningNumbers;

public class BonusNumber extends Number {
    public BonusNumber(int number, WinningNumbers winningNumbers) {
        super(number);
        winningNumbers.validateDuplicate(this);
    }
}
