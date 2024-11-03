package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.PurchaseAmount;
import lotto.service.BonusNumber;
import lotto.service.LottoMachine;
import lotto.service.LottoResultCalculator;
import lotto.service.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final List<Lotto> lottos;
    private LottoMachine lottoMachine;
    private LottoResult lottoResult;

    public LottoController() {
        this.lottos = new ArrayList<>();
    }

    public void run() {
        PurchaseAmount purchaseAmount = initializePurchaseAmount();
        lottoMachine = new LottoMachine(purchaseAmount, lottos);
        OutputView.printPurchaseAmount(purchaseAmount);
        OutputView.printLottos(lottoMachine.getLottos());

        List<Integer> winningNumbers = initializeWinningNumbers();
        int bonusNumberValue = initializeBonusNumber(winningNumbers);

        LottoResultCalculator calculator = new LottoResultCalculator();
        lottoResult = calculator.calculateResults(
                lottoMachine.getLottos(),
                new WinningNumber(winningNumbers),
                new BonusNumber(bonusNumberValue, new WinningNumber(winningNumbers))
        );

        OutputView.printResult(lottoResult);
    }

    private PurchaseAmount initializePurchaseAmount() {
        PurchaseAmount purchaseAmount = null;
        while (purchaseAmount == null) {
            try {
                int purchaseAmountValue = InputView.readPurchaseAmount();
                purchaseAmount = new PurchaseAmount(purchaseAmountValue);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    private List<Integer> initializeWinningNumbers() {
        List<Integer> winningNumbers = null;
        while (winningNumbers == null) {
            try {
                winningNumbers = InputView.readWinningNumbers();
                new WinningNumber(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winningNumbers = null;
            }
        }
        return winningNumbers;
    }

    private int initializeBonusNumber(List<Integer> winningNumbers) {
        int bonusNumberValue = 0;
        boolean validBonusNumber = false;
        while (!validBonusNumber) {
            try {
                bonusNumberValue = InputView.readBonusNumber();
                BonusNumber bonusNumber = new BonusNumber(bonusNumberValue, new WinningNumber(winningNumbers));
                validBonusNumber = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumberValue;
    }
}
