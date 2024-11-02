package lotto.controller;

import java.util.function.Supplier;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.utils.InputHandler;
import lotto.utils.LottoMachine;
import lotto.utils.OutputHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public void run() {
        Money money = generateUntilSuccess(this::toMoney);
        Lottos lottos = generateUntilSuccess(() -> toLottos(money));
        OutputView.printPurchaseInfo(OutputHandler.getCount(lottos), OutputHandler.formatLottos(lottos));
        WinningLotto winningLotto = generateUntilSuccess(this::toWinningLotto);
        Result result = new Result(money, lottos, winningLotto);
        OutputView.printResult(OutputHandler.formatStatistics(result), OutputHandler.getRateOfReturn(result));
    }

    private Money toMoney() {
        return new Money(InputHandler.toMoneyValue(InputView.readMoney()));
    }

    private Lottos toLottos(Money money) {
        return new Lottos(LottoMachine.purchaseLottos(money));
    }

    private WinningLotto toWinningLotto() {
        Lotto winningNumbers = generateUntilSuccess(this::toWinningNumbers);
        BonusNumber bonusNumber = generateUntilSuccess(this::toBonusNumber);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Lotto toWinningNumbers() {
        return new Lotto(InputHandler.toWinningNumbersValue(InputView.readWinningNumbers()));
    }

    private BonusNumber toBonusNumber() {
        return new BonusNumber(InputHandler.toBonusNumberValue(InputView.readBonusNumber()));
    }

    private <T> T generateUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessage(e);
            }
        }
    }
}
