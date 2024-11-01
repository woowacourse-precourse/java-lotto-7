package lotto.io;

import lotto.domain.*;

public interface Input {

    AmountOfLottos inputMoney(int lottoPrize);

    WinningNumbers inputWinningNumbers();

    BonusNumber inputBonusNumber(WinningNumbers winningNumbers);
}
