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

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Money money = generateUntilSuccess(this::toMoney);
        Lottos lottos = generateUntilSuccess(() -> toLottos(money));
        outputView.printPurchaseInfo(OutputHandler.getCount(lottos), OutputHandler.formatLottos(lottos));
        WinningLotto winningLotto = generateUntilSuccess(this::toWinningLotto);
        Result result = new Result(money, lottos, winningLotto);
        outputView.printResult(OutputHandler.formatStatistics(result), OutputHandler.getRateOfReturn(result));
    }

    private Money toMoney() {
        return new Money(InputHandler.toMoneyValue(inputView.readMoney()));
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
        return new Lotto(InputHandler.toWinningNumbersValue(inputView.readWinningNumbers()));
    }

    private BonusNumber toBonusNumber() {
        return new BonusNumber(InputHandler.toBonusNumberValue(inputView.readBonusNumber()));
    }

    private <T> T generateUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }
    }
}
