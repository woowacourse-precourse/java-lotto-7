package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.util.RandomNumberUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        int thousandUnitCount = inputView.readPurchaseAmount();
        outputView.printUnitCount(thousandUnitCount);

        Lottos lottos = new Lottos();
        purchaseLottos(thousandUnitCount, lottos);

        Lotto winningNumber = inputView.readWinningNumbers();
        printLottoResult(winningNumber, lottos, thousandUnitCount);
    }

    private void purchaseLottos(int thousandUnitCount, Lottos lottos) {
        for (int count = 0; count < thousandUnitCount; count++) {
            Lotto lotto = new Lotto(RandomNumberUtils.getRandomNumbers());
            lottos.addLotto(lotto);
            outputView.printPurchaseLottos(lotto);
        }
    }

    private void printLottoResult(Lotto winningNumber, Lottos lottos, int thousandUnitCount) {
        int bonusNumber = inputView.readBonusNumber(winningNumber);
        outputView.printLottoResult(winningNumber, bonusNumber, lottos);
        outputView.printRateOfReturn(thousandUnitCount);
    }
}
