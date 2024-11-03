package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.PurchaseAmount;
import lotto.model.Lottos;
import lotto.model.WinningNumber;
import lotto.model.NumberGenerator;
import lotto.model.WinningResults;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        PurchaseAmount purchaseAmount = purchaseLottos();
        Lottos lottos = lottoMachine.issueLottos(purchaseAmount);
        outputView.outputIssuedLottos(lottos);
        WinningNumber winningNumber = pickWinningNumber();
        BonusNumber bonusNumber = pickBonusNumber(winningNumber);
        WinningResults winningResults = lottoMachine.checkLottoWinningResult(lottos, winningNumber, bonusNumber);
        outputWinningResults(winningResults, purchaseAmount);
    }

    private PurchaseAmount purchaseLottos() {
        try {
            String purchaseAmount = inputView.inputPurchaseAmount();
            return new PurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException e) {
            outputView.outputExceptionMessage(e.getMessage());
            return purchaseLottos();
        }
    }

    private WinningNumber pickWinningNumber() {
        try {
            String winningNumberInput = inputView.inputWinningNumber();
            return NumberGenerator.registerWinningNumber(winningNumberInput);
        } catch (IllegalArgumentException e) {
            outputView.outputExceptionMessage(e.getMessage());
            return pickWinningNumber();
        }
    }

    private BonusNumber pickBonusNumber(WinningNumber winningNumber) {
        try {
            String bonusNumberInput = inputView.inputBonusNumber();
            return NumberGenerator.registerBonusNumber(bonusNumberInput, winningNumber);
        } catch (IllegalArgumentException e) {
            outputView.outputExceptionMessage(e.getMessage());
            return pickBonusNumber(winningNumber);
        }
    }

    private void outputWinningResults(WinningResults winningResults, PurchaseAmount purchaseAmount) {
        outputView.outputWinningResultStartLine();
        outputView.outputWinningRanks(winningResults);
        double earningsRate = lottoMachine.calculateEarningsRate(winningResults, purchaseAmount.getPurchaseAmount());
        outputView.outputEarningsRate(earningsRate);
    }

}
