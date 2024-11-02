package lotto.view;

import lotto.model.Lotto;
import lotto.model.WinningLotto;

public interface InputView {
    int readCost(int lottoPrice);
    Lotto readWinningNumbers();
    WinningLotto readBonusNumber(Lotto winningNumbers);
    void terminate();
}
