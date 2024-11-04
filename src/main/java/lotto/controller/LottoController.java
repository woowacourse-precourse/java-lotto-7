package lotto.controller;

import lotto.common.Converter;
import lotto.dto.WinningNumbersDto;
import lotto.model.winningNumber.BonusNumber;
import lotto.model.lotto.purchaseAmount.PurchaseAmount;
import lotto.model.lotto.lottoNumber.Lottos;
import lotto.service.winningNumber.NumberGenerator;
import lotto.model.winningNumber.MainNumber;
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
        MainNumber mainNumber = pickMainNumber();
        BonusNumber bonusNumber = pickBonusNumber(mainNumber);
        WinningResults winningResults = checkWinningResults(lottos, mainNumber, bonusNumber);
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

    private MainNumber pickMainNumber() {
        try {
            String mainNumberInput = inputView.inputMainNumber();
            return numberGenerator.registerMainNumber(mainNumberInput);
        } catch (IllegalArgumentException e) {
            outputView.outputExceptionMessage(e.getMessage());
            return pickMainNumber();
        }
    }

    private BonusNumber pickBonusNumber(MainNumber mainNumber) {
        try {
            String bonusNumberInput = inputView.inputBonusNumber();
            return numberGenerator.registerBonusNumber(new WinningNumbersDto(bonusNumberInput, mainNumber));
        } catch (IllegalArgumentException e) {
            outputView.outputExceptionMessage(e.getMessage());
            return pickBonusNumber(mainNumber);
        }
    }

    private WinningResults checkWinningResults(Lottos lottos, MainNumber mainNumber,
                                               BonusNumber bonusNumber) {
        return lottoMachine.checkWinningResults(lottos, mainNumber, bonusNumber);
    }

    private void outputWinningResults(WinningResults winningResults, PurchaseAmount purchaseAmount) {
        outputView.outputWinningResultStartLine();
        outputView.outputWinningRanks(winningResults);
        double earningsRate = lottoMachine.calculateEarningsRate(winningResults, purchaseAmount);
        outputView.outputEarningsRate(earningsRate);
    }
}
