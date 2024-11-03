package lotto.controller;

import lotto.model.*;
import lotto.utility.NumberParser;
import lotto.utility.ProfitCalculator;
import lotto.utility.RandomNumberCreator;
import lotto.utility.WinningNumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    public void purchaseLotto() {
        int inputtedCost = inputPurchaseCost();
        PurchaseCost purchaseCost = new PurchaseCost(inputtedCost);

        int purchasedLottoCount = purchaseCost.calculateBuyableLottoCount();
        OutputView.outputPurchasedLottoCount(purchasedLottoCount);
        PurchasedLottos purchasedLottos = new PurchasedLottos(purchaseLotto(purchasedLottoCount));

        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers());
        int bonusNumber = NumberParser.parseToInteger(InputView.inputBonusNumber());
        winningNumbers.checkBonusDuplicate(bonusNumber);

        LottoGame lottoGame = new LottoGame(purchasedLottos, winningNumbers, bonusNumber);
        lottoGame.process();

        outputResult(lottoGame, inputtedCost);
    }

    private int inputPurchaseCost() {
        String rawPurchaseCost = InputView.inputPurchaseCost();
        return NumberParser.parseToInteger(rawPurchaseCost);
    }

    private List<Lotto> purchaseLotto(int purchaseCount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i=0; i<purchaseCount; i++) {
            List<Integer> randomlyGeneratedNumbers = RandomNumberCreator.generateRandomNumbers();
            OutputView.outputPurchaseOneLottoResult(randomlyGeneratedNumbers);
            purchasedLottos.add(new Lotto(randomlyGeneratedNumbers));
        }

        return purchasedLottos;
    }

    private List<Integer> inputWinningNumbers() {
        String rawWinningNumbers = InputView.inputWinningNumbers();
        return WinningNumberParser.parseWinningNumbers(rawWinningNumbers);
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
