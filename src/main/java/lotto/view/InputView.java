package lotto.view;

import lotto.checker.domain.BonusNumber;
import lotto.purchase.domain.Money;
import lotto.checker.domain.WinningNumbers;

public interface InputView {

    Money getMoney();

    WinningNumbers getWinningNumbers();

    BonusNumber getBonusNumber(WinningNumbers winningNumbers);
}
