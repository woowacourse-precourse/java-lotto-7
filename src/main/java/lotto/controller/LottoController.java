package lotto.controller;

import lotto.model.*;
import lotto.service.Calculator;
import lotto.service.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoGenerator = new LottoGenerator();
    }

    public void run() {
        LottoPurchaseAmount purchaseAmount = getPurchaseAmountInput();
        Lottos generatedLottos = handleGeneratingLottos(purchaseAmount.getPurchaseCount());
        WinningNumbers numbers = handleWinningNumbers();

        Calculator calculator = new Calculator(generatedLottos, numbers);
        calculator.calculateLottoResult();

        outputView.printLottoResult(calculator.getLottoResult());
        outputView.printRateOfReturn(calculator.calculateRateOfReturn(purchaseAmount));
    }

    private LottoPurchaseAmount getPurchaseAmountInput() {
        LottoPurchaseAmount purchaseAmount = handlePurchaseAmount();
        outputView.printPurchasedLottoMessage(purchaseAmount.getPurchaseCount());
        return purchaseAmount;
    }

    private Lottos handleGeneratingLottos(int purchaseCount) {
        Lottos generatedLottos = lottoGenerator.generateLottos(purchaseCount);
        outputView.printPurchasedLottos(generatedLottos);
        return generatedLottos;
    }

    private LottoPurchaseAmount handlePurchaseAmount() {
        while (true) {
            try {
                String amount = inputView.inputPurchaseAmount();
                return new LottoPurchaseAmount(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers handleWinningNumbers() {
        while (true) {
            try {
                Lotto winningNumbers = new Lotto(inputView.inputWinningNumbers());
                BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());
                return new WinningNumbers(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
