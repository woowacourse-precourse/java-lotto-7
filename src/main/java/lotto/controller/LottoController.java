package lotto.controller;

import lotto.Lotto;
import lotto.domain.BonusNumber;
import lotto.domain.LottoGame;
import lotto.domain.PurchaseAmount;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        PurchaseAmount amount = readPurchasePrice();
        LottoGame game = new LottoGame(amount, new RandomLottoGenerator());
        outputView.printPurchaseAmount(game.getLottoCount());
        outputView.printLotto(game.getLottoScreen());
        Lotto winningNumber = readWinningNumber();
        BonusNumber bonusNumber = readBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        outputView.printLottoResult(game.getResultScreen(winningLotto));
    }

    private PurchaseAmount readPurchasePrice() {
        outputView.printPurchaseGuide();
        return inputView.readPurchasePrice();
    }

    private Lotto readWinningNumber() {
        outputView.printWinningNumberGuide();
        return inputView.readWinningNumber();
    }

    private BonusNumber readBonusNumber() {
        outputView.printBonusNumberGuide();
        return inputView.readBonusNumber();
    }
}
