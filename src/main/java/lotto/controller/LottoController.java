package lotto.controller;

import lotto.model.PurchaseCost;
import lotto.utility.PurchaseCostParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void purchaseLotto() {
        int inputtedCost = inputPurchaseCost();
        PurchaseCost purchaseCost = new PurchaseCost(inputtedCost);

        int purchasedLottoCount = purchaseCost.calculateBuyableLottoCount();
        OutputView.outputPurchasedLottoCount(purchasedLottoCount);
    }

    public int inputPurchaseCost() {
        String rawPurchaseCost = InputView.inputPurchaseCost();
        return PurchaseCostParser.parseToInteger(rawPurchaseCost);
    }
}
