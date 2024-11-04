package lotto.controller;

import lotto.model.*;
import lotto.utility.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    public void purchaseLotto() {
        PurchaseCost purchaseCost = inputPurchaseCost();
        PurchasedLottos purchasedLottos = purchase(purchaseCost);
        WinningNumbers winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);

        LottoGame lottoGame = new LottoGame(purchasedLottos, winningNumbers, bonusNumber);
        lottoGame.process();

        outputResult(lottoGame, purchaseCost.getPurchaseCost());
    }

    private PurchaseCost inputPurchaseCost() {
        try {
            String rawPurchaseCost = InputView.inputPurchaseCost();
            int parsedCost = NumberParser.parseToInteger(rawPurchaseCost);

            return new PurchaseCost(parsedCost);
        } catch (IllegalArgumentException exception) {
            return inputPurchaseCost();
        }
    }

    private PurchasedLottos purchase(PurchaseCost purchaseCost) {
        int purchasedLottoCount = purchaseCost.calculateBuyableLottoCount();
        OutputView.outputPurchasedLottoCount(purchasedLottoCount);

        List<Lotto> purchasedLottos = generateLottoWithPurchaseCount(purchasedLottoCount);
        return new PurchasedLottos(purchasedLottos);
    }

    private List<Lotto> generateLottoWithPurchaseCount(int purchaseCount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i=0; i<purchaseCount; i++) {
            List<Integer> randomlyGeneratedNumbers = RandomNumberCreator.generateRandomNumbers();
            OutputView.outputPurchaseOneLottoResult(randomlyGeneratedNumbers);
            purchasedLottos.add(new Lotto(randomlyGeneratedNumbers));
        }

        return purchasedLottos;
    }

    private WinningNumbers inputWinningNumbers() {
        try {
            String rawWinningNumbers = InputView.inputWinningNumbers();
            List<Integer> parsedWinningNumbers = WinningNumberParser.parseWinningNumbers(rawWinningNumbers);
            return new WinningNumbers(parsedWinningNumbers);
        } catch (IllegalArgumentException exception) {
            return inputWinningNumbers();
        }
    }

    private int inputBonusNumber(WinningNumbers winningNumbers) {
        try {
            int bonusNumber = NumberParser.parseToInteger(InputView.inputBonusNumber());
            winningNumbers.checkBonusDuplicate(bonusNumber);
            BonusNumberValidator.validateUnderFourtySix(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException exception) {
            return inputBonusNumber(winningNumbers);
        }
    }

    private void outputProfitRate(int purchaseCost, Map<String, Integer> matchedCount) {
        String profitRate = ProfitCalculator.calculate(purchaseCost, matchedCount);
        OutputView.outputProfitRate(profitRate);
    }

    private void outputResult(LottoGame lottoGame, int inputtedCost) {
        OutputView.outputMatchedCount(lottoGame.getLottoMatchedCount());
        outputProfitRate(inputtedCost, lottoGame.getLottoMatchedCount());

    }
}
