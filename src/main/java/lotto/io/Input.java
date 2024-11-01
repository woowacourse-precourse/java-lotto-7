package lotto.io;

import lotto.domain.*;

public interface Input {

    AmountOfLottos inputMoney();

    WinningNumbers inputWinningNumbers();

    BonusNumber inputBonusNumber();
}
