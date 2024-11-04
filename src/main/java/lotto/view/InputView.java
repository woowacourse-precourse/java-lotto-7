package lotto.view;

import lotto.model.Lotto;

public interface InputView {

    String inputMoney();

    String inputWinningNumbers();

    String inputBonusNumber(Lotto lotto);
}
