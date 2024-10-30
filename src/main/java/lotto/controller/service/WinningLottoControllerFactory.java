package lotto.controller.service;

import lotto.controller.domain.WinningLottoController;
import lotto.lotto.winning.infrastructure.BonusNumberCreator;
import lotto.lotto.winning.infrastructure.WinningLottoCreator;
import lotto.view.input.hanlder.infrastructure.BonusNumberHandler;
import lotto.view.input.hanlder.infrastructure.WinningLottoHandler;
import lotto.view.input.infrastructure.BonusNumberInput;
import lotto.view.input.infrastructure.WinningLottoInput;
import lotto.view.output.infrastructure.BonusNumberOutput;
import lotto.view.output.infrastructure.WinningLottoOutput;

public class WinningLottoControllerFactory {
    public static WinningLottoController create() {
        WinningLottoCreator winningLottoCreator = new WinningLottoCreator(new WinningLottoHandler(new WinningLottoInput(new WinningLottoOutput())));
        BonusNumberCreator bonusNumberCreator = new BonusNumberCreator(new BonusNumberHandler(new BonusNumberInput(new BonusNumberOutput())));
        return new WinningLottoController(winningLottoCreator, bonusNumberCreator);
    }

}
