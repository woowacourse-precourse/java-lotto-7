package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.exception.InputException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    public void run() {
        Money money = repeatUntilReadValidInput(this::readMoney);

        Lottos lottos = generateLottos(money);
    }

    private Money readMoney() {
        OutputView.askPurchasePrice();
        return Money.from(InputView.readInput());
    }

    private Lottos generateLottos(Money money) {
        LottoMachine lottoMachine = LottoMachine.from(money);
        List<Lotto> lottos = lottoMachine.publishLotto();
        return Lottos.from(lottos);
    }

    private <T> T repeatUntilReadValidInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (InputException exception) {
                OutputView.printErrorMessage(exception);
            }
        }
    }
}
