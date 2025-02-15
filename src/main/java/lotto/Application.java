package lotto;

import lotto.controller.PurchaseController;
import lotto.model.LottoResult;
import lotto.model.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        PurchaseController purchaseController = new PurchaseController();

        purchaseController.purchaseLottos();

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(winningNumbers);

        OutputView.printPurchasedLottos(purchaseController.getPurchasedLottos());

        LottoResult lottoResult = purchaseController.calculateResult(winningNumbers, bonusNumber);
        double yield = lottoResult.calculateYield(purchaseController.getPurchasedLottos().size() * LottoStore.LOTTO_PRICE);
        OutputView.printResult(lottoResult, yield);
    }
}
