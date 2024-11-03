package lotto.view;

import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;

public interface InputView {

    Money getMoney();

    WinningNumbers getWinningNumbers();

    BonusNumber getBonusNumber(WinningNumbers winningNumbers);
}
