package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Profit;
import lotto.domain.WinNumber;
import lotto.exception.InputException;
import lotto.util.ConvertInput;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    public void run() {
        Money money = repeatUntilReadValidInput(this::readMoney);

        Lottos lottos = generateLottos(money);
        showLottoNumbers(money, lottos);

        WinNumber winNumber = makeWinNumber();
        processResult(lottos, winNumber, money);
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

    private void showLottoNumbers(Money money, Lottos lottos) {
        OutputView.printPurchasedResult(money.calculateTicketCount(), lottos.getLottos());
    }

    private WinNumber makeWinNumber() {
        Lotto winningNumber = repeatUntilReadValidInput(this::readWinningNumber);
        BonusNumber bonusNumber = repeatUntilReadValidInput(this::readBonusNumber);
        return WinNumber.of(winningNumber, bonusNumber);
    }

    private Lotto readWinningNumber() {
        OutputView.askWinningNumber();
        List<Integer> winningNumber = ConvertInput.makeWinningNumberToList(InputView.readInput());
        return new Lotto(winningNumber);
    }

    private BonusNumber readBonusNumber() {
        OutputView.askBonusNumber();
        return BonusNumber.from(InputView.readInput());
    }

    private void processResult(Lottos lottos, WinNumber winNumber, Money money) {
        LottoResult lottoResult = LottoResult.of(lottos, winNumber);
        Profit profit = Profit.of(money, lottoResult);
        OutputView.printLottoResult(lottoResult, profit);
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
