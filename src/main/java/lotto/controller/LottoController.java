package lotto.controller;

import lotto.model.*;
import lotto.utility.NumberParser;
import lotto.utility.RandomNumberCreator;
import lotto.utility.WinningNumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void purchaseLotto() {
        int inputtedCost = inputPurchaseCost();
        PurchaseCost purchaseCost = new PurchaseCost(inputtedCost);

        int purchasedLottoCount = purchaseCost.calculateBuyableLottoCount();
        OutputView.outputPurchasedLottoCount(purchasedLottoCount);
        PurchasedLottos purchasedLottos = new PurchasedLottos(purchaseLotto(purchasedLottoCount));

        List<Integer> parsedWinningNumbers = inputWinningNumbers();
        WinningNumbers winningNumbers = new WinningNumbers(parsedWinningNumbers);
        int bonusNumber = NumberParser.parseToInteger(InputView.inputBonusNumber());

        LottoGame lottoGame = new LottoGame(purchasedLottos, purchaseCost, winningNumbers, bonusNumber);
        lottoGame.process();
    }

    public int inputPurchaseCost() {
        String rawPurchaseCost = InputView.inputPurchaseCost();
        return NumberParser.parseToInteger(rawPurchaseCost);
    }

    public List<Lotto> purchaseLotto(int purchaseCount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i=0; i<purchaseCount; i++) {
            List<Integer> randomlyGeneratedNumbers = RandomNumberCreator.generateRandomNumbers();
            OutputView.outputPurchaseOneLottoResult(randomlyGeneratedNumbers);
            purchasedLottos.add(new Lotto(randomlyGeneratedNumbers));
        }

        return purchasedLottos;
    }

    public List<Integer> inputWinningNumbers() {
        String rawWinningNumbers = InputView.inputWinningNumbers();
        return WinningNumberParser.parseWinningNumbers(rawWinningNumbers);
    }
}
