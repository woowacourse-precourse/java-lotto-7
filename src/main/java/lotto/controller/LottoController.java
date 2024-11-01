package lotto.controller;

import lotto.model.Lotto;
import lotto.model.PurchaseCost;
import lotto.utility.PurchaseCostParser;
import lotto.utility.RandomNumberCreator;
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

        purchaseLotto(purchasedLottoCount);
    }

    public int inputPurchaseCost() {
        String rawPurchaseCost = InputView.inputPurchaseCost();
        return PurchaseCostParser.parseToInteger(rawPurchaseCost);
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
}
