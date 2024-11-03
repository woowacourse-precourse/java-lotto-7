package lotto.domain.number;

import lotto.domain.lottoForm.WinningNumbers;

public class BonusNumber extends LottoNumber {
    public BonusNumber(int number, WinningNumbers winningNumbers) {
        super(number);
        winningNumbers.validateDuplicate(this);
    }
}
