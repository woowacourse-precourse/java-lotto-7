package lotto.service.winningNumber;

import lotto.model.winningNumber.BonusNumber;
import lotto.model.winningNumber.MainNumber;

public interface NumberGenerator<T, U> {
    MainNumber registerMainNumber(T input);

    BonusNumber registerBonusNumber(U input);
}
