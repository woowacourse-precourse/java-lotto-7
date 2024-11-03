package lotto.controller;

import lotto.common.Converter;
import lotto.dto.AllWinningNumberDto;
import lotto.model.winningNumber.BonusNumber;
import lotto.model.lotto.purchaseAmount.PurchaseAmount;
import lotto.model.lotto.lottoNumber.Lottos;
import lotto.service.winningNumber.NumberGenerator;
import lotto.model.winningNumber.WinningNumber;
import lotto.model.lotto.winningResult.WinningResults;
import lotto.service.lotto.LottoMachine;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;
    private final NumberGenerator numberGenerator;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine,
                           NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        PurchaseAmount purchaseAmount = purchaseLottos();
        Lottos lottos = issueLottos(purchaseAmount);
        outputIssuedLottos(lottos);
        WinningNumber winningNumber = pickWinningNumber();
        BonusNumber bonusNumber = pickBonusNumber(winningNumber);
        WinningResults winningResults = checkWinningResults(lottos, winningNumber, bonusNumber);
        outputWinningResults(winningResults, purchaseAmount);
    }

    private PurchaseAmount purchaseLottos() {
        try {
            String purchaseAmountInput = inputView.inputPurchaseAmount();
            return new PurchaseAmount(Converter.toInteger(purchaseAmountInput));
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
            return numberGenerator.registerWinningNumber(winningNumberInput);
        } catch (IllegalArgumentException e) {
            outputView.outputExceptionMessage(e.getMessage());
            return pickWinningNumber();
        }
    }

    private BonusNumber pickBonusNumber(WinningNumber winningNumber) {
        try {
            String bonusNumberInput = inputView.inputBonusNumber();
            return numberGenerator.registerBonusNumber(new AllWinningNumberDto(bonusNumberInput, winningNumber));
        } catch (IllegalArgumentException e) {
            outputView.outputExceptionMessage(e.getMessage());
            return pickBonusNumber(winningNumber);
        }
    }

    private WinningResults checkWinningResults(Lottos lottos, WinningNumber winningNumber,
                                               BonusNumber bonusNumber) {
        return lottoMachine.checkWinningResults(lottos, winningNumber, bonusNumber);
    }

    private void outputWinningResults(WinningResults winningResults, PurchaseAmount purchaseAmount) {
        outputView.outputWinningResultStartLine();
        outputView.outputWinningRanks(winningResults);
        double earningsRate = lottoMachine.calculateEarningsRate(winningResults, purchaseAmount);
        outputView.outputEarningsRate(earningsRate);
    }
}
