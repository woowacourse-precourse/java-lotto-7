package lotto;

import lotto.domain.LottoManager;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinnerLotto;
import lotto.io.InputView;
import lotto.io.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try (InputView inputView = new InputView()) {
            PurchaseAmount purchaseAmount = inputView.inputPurchaseAmount();
            LottoManager lottoManager = LottoManager.from(purchaseAmount.getAmount());

            OutputView.printPurchaseLottos(lottoManager.getPublishedLottos());
            WinnerLotto winnerLotto = inputView.inputWinningNumbers();
            winnerLotto = inputView.inputBonusNumbers(winnerLotto);
            lottoManager = lottoManager.withWinningLotto(winnerLotto);

            OutputView.printTotalResult(lottoManager.getPrizeResult(), lottoManager.getProfitRate());
        }
    }
}
