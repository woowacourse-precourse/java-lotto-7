package lotto.controller;

import lotto.model.LottoChecker;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.ReturnRate;
import lotto.model.Trial;
import lotto.model.WinningMoney;
import lotto.model.WinningNumber;
import lotto.model.numbergenerator.NumberGenerator;
import lotto.model.numbergenerator.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public void run() {
        Money money = inputMoneyWithRetry();
        Trial trial = new Trial(money.getMoney());
        Lottos lottos = new Lottos(numberGenerator, trial);
        OutputView.printLotties(lottos.getLottoNums());

        WinningNumber winningNumber = inputWinningNumberWithRetry();
        LottoChecker lottoChecker = new LottoChecker(lottos, winningNumber);
        WinningMoney winningMoney = new WinningMoney(lottoChecker.checkLottos());
        ReturnRate returnRate = new ReturnRate(winningMoney, money);

        OutputView.printWinningDetails(lottoChecker.getResultMap());
        OutputView.printReturnRate(returnRate.getReturnRate());
    }

    private Money inputMoneyWithRetry() {
        while (true) {
            try {
                return new Money(InputView.inputMoney());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumber inputWinningNumberWithRetry() {
        while (true) {
            try {
                return new WinningNumber(InputView.inputWinningNumber(), InputView.inputBonusNumber());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
