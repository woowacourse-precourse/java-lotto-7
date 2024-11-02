package lotto.controller;

import java.util.function.Supplier;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.utils.InputConvertor;
import lotto.utils.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public void run() {
        Money money = generateUntilSuccess(this::convertToMoney);
        Lottos lottos = generateUntilSuccess(() -> convertToLottos(money));
        OutputView.printPurchaseLottos(lottos);
        WinningLotto winningLotto = generateUntilSuccess(this::convertToWinningLotto);
        Result result = new Result(money, lottos, winningLotto);
        OutputView.printResult(result);
    }

    private Money convertToMoney() {
        return new Money(InputConvertor.convertMoneyInput(InputView.readMoney()));
    }

    private Lottos convertToLottos(Money money) {
        return new Lottos(LottoMachine.purchaseLottos(money));
    }

    private WinningLotto convertToWinningLotto() {
        Lotto winningNumbers = generateUntilSuccess(this::convertToWinningNumbers);
        BonusNumber bonusNumber = generateUntilSuccess(this::convertToBonusNumber);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Lotto convertToWinningNumbers() {
        return new Lotto(InputConvertor.convertWinningNumbersInput(InputView.readWinningNumbers()));
    }

    private BonusNumber convertToBonusNumber() {
        return new BonusNumber(InputConvertor.convertBonusNumberInput(InputView.readBonusNumber()));
    }

    private <T> T generateUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
    }
}
