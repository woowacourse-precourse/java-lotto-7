package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoContainer;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPayment;
import lotto.domain.Results;
import lotto.domain.WinningLotto;
import lotto.ui.InputController;
import lotto.ui.OutputController;
import lotto.ui.Repeater;

public class LottoGame {
    private final InputController inputController;
    private final OutputController outputController;
    private final Repeater repeater;
    private final LottoGenerator lottoGenerator;

    public LottoGame(
            final InputController inputController,
            final OutputController outputController,
            final Repeater repeater,
            final LottoGenerator lottoGenerator)
    {
        this.inputController = inputController;
        this.outputController = outputController;
        this.repeater = repeater;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        final LottoPayment lottoPayment = getLottoPayment();
        final LottoContainer lottoContainer = getLottoContainer(lottoPayment);
        final WinningLotto winningLotto = getWinningLotto();

        final Results results = lottoContainer.verifyResults(winningLotto);
        printResults(results, lottoPayment);
    }

    private LottoContainer getLottoContainer(final LottoPayment lottoPayment) {
        final LottoContainer container = lottoGenerator.generate(lottoPayment);
        outputController.printAllLotteries(container);
        return container;
    }

    private LottoPayment getLottoPayment() {
        outputController.printPurchaseInfo();
        return repeater.repeatWithErrorMessage(() -> inputController.getPayment());
    }

    private WinningLotto getWinningLotto() {
        outputController.printToGetWinningNumberInput();
        final Lotto lotto = repeater.repeatWithErrorMessage(() -> inputController.getLotto());

        outputController.printToGetBonusNumberInput();
        return repeater.repeatWithErrorMessage(() -> {
            final LottoNumber bonusNumber = inputController.getBonusNumber();
            return new WinningLotto(lotto, bonusNumber);
        });
    }

    private void printResults(final Results results, final LottoPayment lottoPayment) {
        outputController.printStatisticResults(results);
        outputController.printProfitRatio(results, lottoPayment);
    }
}
