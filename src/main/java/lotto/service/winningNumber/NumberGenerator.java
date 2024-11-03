package lotto.service.winningNumber;

import lotto.model.winningNumber.BonusNumber;
import lotto.model.winningNumber.MainNumber;

public interface NumberGenerator<T, U> {
    MainNumber registerWinningNumber(T input);

    BonusNumber registerBonusNumber(U input);
}
