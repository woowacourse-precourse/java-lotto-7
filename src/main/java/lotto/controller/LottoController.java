package lotto.controller;

import lotto.model.winningNumber.BonusNumber;
import lotto.model.lotto.PurchaseAmount;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.PurchaseAmountGenerator;
import lotto.model.winningNumber.WinningNumber;
import lotto.model.winningNumber.NumberGenerator;
import lotto.model.winningResult.WinningResults;
import lotto.service.LottoMachine;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

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
        Lottos lottos = issueLottos(purchaseAmount);
        outputIssuedLottos(lottos);
        WinningNumber winningNumber = pickWinningNumber();
        BonusNumber bonusNumber = pickBonusNumber(winningNumber);
        WinningResults winningResults = checkLottoWinningResult(lottos, winningNumber, bonusNumber);
        outputWinningResults(winningResults, purchaseAmount);
    }

    private PurchaseAmount purchaseLottos() {
        try {
            String purchaseAmountInput = inputView.inputPurchaseAmount();
            return PurchaseAmountGenerator.registerPurchaseAmount(purchaseAmountInput);
        } catch (IllegalArgumentException e) {
            outputView.outputExceptionMessage(e.getMessage());
            return purchaseLottos();
        }
    }

    private Lottos issueLottos(PurchaseAmount purchaseAmount) {
        return lottoMachine.issueLottos(purchaseAmount);
    }

    private void outputIssuedLottos(Lottos lottos) {
        outputView.outputIssuedLottos(lottos);
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

    private WinningResults checkLottoWinningResult(Lottos lottos, WinningNumber winningNumber,
                                                   BonusNumber bonusNumber) {
        return lottoMachine.checkLottoWinningResult(lottos, winningNumber, bonusNumber);
    }

    private void outputWinningResults(WinningResults winningResults, PurchaseAmount purchaseAmount) {
        outputView.outputWinningResultStartLine();
        outputView.outputWinningRanks(winningResults);
        double earningsRate = lottoMachine.calculateEarningsRate(winningResults, purchaseAmount.getPurchaseAmount());
        outputView.outputEarningsRate(earningsRate);
    }

}
