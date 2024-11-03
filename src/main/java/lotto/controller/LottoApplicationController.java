package lotto.controller;

import java.util.List;
import lotto.aop.RetryHandler;
import lotto.controller.lottoController.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoStatics;
import lotto.domain.Money;
import lotto.domain.Number;
import lotto.domain.WinningLotto;
import lotto.domain.numberPicker.NumberPicker;
import lotto.dto.IncomeStatics;
import lotto.dto.PrizeStatics;
import lotto.dto.PurchasedLottos;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class LottoApplicationController {

    private final LottoController lottoController;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final RetryHandler retryHandler;

    public LottoApplicationController(
            LottoController lottoController,
            InputHandler inputHandler,
            OutputHandler outputHandler,
            RetryHandler retryHandler
    ) {
        this.lottoController = lottoController;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.retryHandler = retryHandler;
    }

    public void run() {
        Money money = retryHandler.tryUntilSuccess(() -> {
            int amount = inputHandler.handlePurchaseCost();
            return new Money(amount);
        });

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

        LottoStatics lottoStatics = new LottoStatics(purchasedLottos, winningLotto, money);

        outputHandler.handlePrizeStatics(PrizeStatics.from(lottoStatics));
        outputHandler.handleIncomeStatics(IncomeStatics.from(lottoStatics));
    }
}
