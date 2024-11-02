package lotto.controller;

import lotto.domain.lotto.PurchasedLottos;
import lotto.domain.lotto.WinningLottos;
import lotto.domain.number.BonusNumber;
import lotto.domain.number.WinningNumbers;
import lotto.domain.result.WinningResult;
import lotto.global.constant.LottoConstant;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        PurchasedLottos purchasedLottos = purchaseLottos();
        WinningResult winningResult = checkWinningResult(purchasedLottos);
        displayResults(winningResult);
    }

    private PurchasedLottos purchaseLottos() {
        int purchaseAmount = inputView.readPurchaseAmount();
        PurchasedLottos purchasedLottos = PurchasedLottos.from(calculatePurchaseCount(purchaseAmount));
        outputView.printPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    private WinningResult checkWinningResult(PurchasedLottos purchasedLottos) {
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = BonusNumber.from(inputView.readBonusNumber());
        return createWinningResult(purchasedLottos, winningNumbers, bonusNumber);
    }

    private WinningNumbers getWinningNumbers() {
        return WinningNumbers.from(inputView.readWinningNumbers());
    }

    private WinningResult createWinningResult(
            PurchasedLottos purchasedLottos,
            WinningNumbers winningNumbers,
            BonusNumber bonusNumber
    ) {
        WinningLottos winningLottos = WinningLottos.of(purchasedLottos, winningNumbers, bonusNumber);
        return WinningResult.of(winningLottos, purchasedLottos.getPurchasedLottos().size());
    }

    private void displayResults(WinningResult winningResult) {
        outputView.printWinningStatistics(winningResult);
    }

    private int calculatePurchaseCount(int purchaseAmount) {
        return purchaseAmount / LottoConstant.LOTTO_PRICE;
    }
}