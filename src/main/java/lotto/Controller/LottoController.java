package lotto.Controller;

import java.util.List;
import lotto.Model.Lotto;
import lotto.Model.LottoResult;
import lotto.Model.WinningLotto;
import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            int purchaseAmount = InputView.inputPurchaseAmount();
            List<Lotto> purchasedLottos = lottoService.purchaseLottos(purchaseAmount);
            OutputView.printPurchasedLottos(purchasedLottos);

            WinningLotto winningLotto = InputView.inputWinningLotto();
            LottoResult result = lottoService.checkResults(purchasedLottos, winningLotto);

            OutputView.printLottoResult(result);
            OutputView.printProfitRate(result.calculateProfitRate(purchaseAmount));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
