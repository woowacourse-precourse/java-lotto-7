package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private LottoService lottoService;

    public LottoController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        this.lottoService = new LottoService(purchaseAmount);
        String lottosState = lottoService.getLottosState();
        printLottoPurchaseResult(purchaseAmount,lottosState);
        WinningLotto winningLotto = readWinningNumber();

    }

    private WinningLotto readWinningNumber() {
        outputView.printReadWinningNumber();
        String winningNumber = inputView.readLine();
        outputView.printReadBonusNumber();
        return new WinningLotto(winningNumber);
    }

    private void printLottoPurchaseResult(PurchaseAmount purchaseAmount, String lottosState) {
        int numberOfLotto = purchaseAmount.getNumberOfLotto();
        outputView.printLottoPurchaseResult(numberOfLotto);
        outputView.printLottoState(lottosState);
    }

    private PurchaseAmount readPurchaseAmount() {
        outputView.printReadPurchaseAmount();
        double purchaseAmount = inputView.readPurchaseAmount();
        return new PurchaseAmount(purchaseAmount);
    }
}
