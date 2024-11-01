package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.utils.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public void run() {
        Money money = inputMoney();
        Lottos lottos = purchaseLottos(money);
        OutputView.printPurchaseLottos(lottos);
        WinningLotto winningLotto = new WinningLotto(inputWinningNumbers(), inputBonusNumber());
        Result result = new Result(money, lottos, winningLotto);
        OutputView.printResult(result);
        OutputView.printRateOfReturn(result);
    }

    private Money inputMoney() {
        while (true) {
            try {
                return new Money(InputView.inputMoney());
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
    }

    private Lottos purchaseLottos(Money money) {
        while (true) {
            try {
                return new Lottos(LottoMachine.purchaseLottos(money));
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
    }

    private Lotto inputWinningNumbers() {
        while (true) {
            try {
                return new Lotto(InputView.inputWinningNumbers());
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
    }

    private BonusNumber inputBonusNumber() {
        while (true) {
            try {
                return new BonusNumber(InputView.inputBonusNumber());
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
    }
}
