package lotto;

import lotto.ui.InputController;
import lotto.ui.OutputController;
import lotto.ui.UiInitializer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final OutputController outputController = UiInitializer.initOutputController();
        final InputController inputController = UiInitializer.initInputController();

        outputController.printPurchaseInfo();
        final LottoPayment lottoPayment = inputController.getPayment();
        outputController.printToGetWinningNumberInput();
        final Lotto inputWinnerLotto = inputController.getLotto();
        outputController.printToGetBonusNumberInput();
        final LottoNum bonusNumber = inputController.getBonusNumber();

        final WinningLotto winningLotto = new WinningLotto(inputWinnerLotto, bonusNumber);

        final LottoContainer container = new LottoGenerator().generate(lottoPayment);

        final Results results = container.verifyResults(winningLotto);

        outputController.printAllLotteries(container);
        outputController.printStatisticResults(results);
        outputController.printProfitRatio(results, lottoPayment);
    }
}
