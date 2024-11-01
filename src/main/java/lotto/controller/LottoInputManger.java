package lotto.controller;

import lotto.domain.BonusComponent;
import lotto.domain.Lotto;

public interface LottoInputManger {

    int getInputPrice();

    Lotto getInputWinningComponent();

    BonusComponent getInputBonusComponent(Lotto WinningComponent);
}
