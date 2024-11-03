package lotto.controller;

import java.util.List;
import lotto.aop.RetryHandler;
import lotto.controller.lottoController.LottoController;
import lotto.controller.lottoStaticsController.LottoStaticsController;
import lotto.controller.moneyController.MoneyController;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Number;
import lotto.domain.WinningLotto;
import lotto.dto.PurchasedLottos;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class LottoApplicationController {

    private final MoneyController moneyController;
    private final LottoController lottoController;
    private final LottoStaticsController lottoStaticsController;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final RetryHandler retryHandler;

    public LottoApplicationController(
            MoneyController moneyController,
            LottoController lottoController,
            LottoStaticsController lottoStaticsController,
            InputHandler inputHandler,
            OutputHandler outputHandler,
            RetryHandler retryHandler
    ) {
        this.moneyController = moneyController;
        this.lottoController = lottoController;
        this.lottoStaticsController = lottoStaticsController;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.retryHandler = retryHandler;
    }

    public void run() {
        Money money = moneyController.readMoney();

        List<Lotto> purchasedLottos = lottoController.purchaseLottos(money);

        outputHandler.handlePurchasedLottos(PurchasedLottos.from(purchasedLottos));

        Lotto winningNumbers = retryHandler.tryUntilSuccess(() -> {
            List<Number> list = inputHandler.handleWinningNumbers().stream().map(Number::new).toList();
            return new Lotto(list);
        });

        WinningLotto winningLotto = retryHandler.tryUntilSuccess(() -> {
            int bonusNumber = inputHandler.handleBonusNumber();
            return new WinningLotto(winningNumbers, new Number(bonusNumber));
        });

        lottoStaticsController.printLottoStatics(purchasedLottos, winningLotto, money);
    }
}
