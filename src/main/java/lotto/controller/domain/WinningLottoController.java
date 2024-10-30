package lotto.controller.domain;

import lotto.lotto.winning.domain.BonusNumber;
import lotto.lotto.winning.domain.WinningLotto;
import lotto.lotto.winning.infrastructure.BonusNumberCreator;
import lotto.lotto.winning.infrastructure.WinningLottoCreator;

public class WinningLottoController {
    private final WinningLottoCreator winningLottoCreator;
    private final BonusNumberCreator bonusNumberCreator;

    public WinningLottoController(
            WinningLottoCreator winningLottoCreator,
            BonusNumberCreator bonusNumberCreator) {
        this.bonusNumberCreator = bonusNumberCreator;
        this.winningLottoCreator = winningLottoCreator;
    }

    public WinningLotto createWinningLotto() {
        return winningLottoCreator.create();
    }

    public BonusNumber createBonusNumber(WinningLotto winningLotto) {
        return bonusNumberCreator.create(winningLotto);
    }
}
