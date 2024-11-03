package lotto.service.winningNumber;

import lotto.model.winningNumber.BonusNumber;
import lotto.model.winningNumber.WinningNumber;

public interface NumberGenerator<T, U> {
    WinningNumber registerWinningNumber(T input);

    BonusNumber registerBonusNumber(U input);
}
