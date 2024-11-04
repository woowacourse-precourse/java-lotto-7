package lotto;

import lotto.controller.LottoController;
import lotto.dto.LottoResult;
import lotto.dto.PurchaseLotto;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        PurchaseLotto purchaseLotto = lottoController.purchaseLotto();
        OutputView.printPurchaseLotto(purchaseLotto);
        lottoController.registerWinningLotto();

        LottoResult lottoResult = lottoController.getLottoResult();
        OutputView.printResult(lottoResult);
    }
}
