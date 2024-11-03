package lotto.controller;

import lotto.Lotto;
import lotto.domain.BonusNumber;
import lotto.domain.LottoGame;
import lotto.domain.PurchaseAmount;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.function.Supplier;

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
        WinningLotto winningLotto = readWinningLotto();
        outputView.printLottoResult(game.getResultScreen(winningLotto));
    }

    private PurchaseAmount readPurchasePrice() {
        return attemptedRead(() -> {
            outputView.printPurchaseGuide();
            return inputView.readPurchasePrice();
        });
    }

    private WinningLotto readWinningLotto() {
        return attemptedRead(() -> {
            Lotto winningLotto = readWinningNumber();
            BonusNumber bonusNumber = readBonusNumber();
            return new WinningLotto(winningLotto, bonusNumber);
        });
    }

    private Lotto readWinningNumber() {
        return attemptedRead(() -> {
            outputView.printWinningNumberGuide();
            return inputView.readWinningNumber();
        });
    }

    private BonusNumber readBonusNumber() {
        return attemptedRead(() -> {
            outputView.printBonusNumberGuide();
            return inputView.readBonusNumber();
        });
    }

    private <T> T attemptedRead(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            outputView.printNewLine();
            return supplier.get();
        }
    }
}
