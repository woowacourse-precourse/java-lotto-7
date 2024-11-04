package lotto.controller.winningLottoController;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public interface WinningLottoController {

    Lotto readWinningNumbers();

    WinningLotto createWinningLotto(Lotto winningNumbers);
}
