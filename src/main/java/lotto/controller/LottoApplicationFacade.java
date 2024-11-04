package lotto.controller;

import java.util.List;
import lotto.controller.lottoController.LottoController;
import lotto.controller.lottoStaticsController.LottoStaticsController;
import lotto.controller.moneyController.MoneyController;
import lotto.controller.winningLottoController.WinningLottoController;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public class LottoApplicationFacade {

    private final MoneyController moneyController;
    private final LottoController lottoController;
    private final WinningLottoController winningLottoController;
    private final LottoStaticsController lottoStaticsController;

    public LottoApplicationFacade(
            MoneyController moneyController,
            LottoController lottoController,
            WinningLottoController winningLottoController,
            LottoStaticsController lottoStaticsController
    ) {
        this.moneyController = moneyController;
        this.lottoController = lottoController;
        this.winningLottoController = winningLottoController;
        this.lottoStaticsController = lottoStaticsController;
    }

    public void run() {
        Money money = moneyController.readMoney();
        List<Lotto> purchasedLottos = lottoController.purchaseLottos(money);
        Lotto winningNumbers = winningLottoController.readWinningNumbers();
        WinningLotto winningLotto = winningLottoController.createWinningLotto(winningNumbers);
        lottoStaticsController.printLottoStatics(purchasedLottos, winningLotto, money);
    }
}
