package lotto;

import lotto.ui.InputController;
import lotto.ui.OutputController;
import lotto.ui.Repeater;
import lotto.ui.UiInitializer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final OutputController outputController = UiInitializer.initOutputController();
        final InputController inputController = UiInitializer.initInputController();
        final Repeater repeater = new Repeater(outputController);

        outputController.printPurchaseInfo();
        final LottoPayment lottoPayment = repeater.repeat(() -> inputController.getPayment());
        final LottoContainer container = new LottoGenerator().generate(lottoPayment);
        outputController.printAllLotteries(container);

        outputController.printToGetWinningNumberInput();
        final Lotto inputWinnerLotto = repeater.repeat(() -> inputController.getLotto());
        outputController.printToGetBonusNumberInput();
        final WinningLotto winningLotto = repeater.repeat(() -> {
            final LottoNum bonusNumber = inputController.getBonusNumber();
            return new WinningLotto(inputWinnerLotto, bonusNumber);
        });

        final Results results = container.verifyResults(winningLotto);

        outputController.printStatisticResults(results);
        outputController.printProfitRatio(results, lottoPayment);
    }
}
