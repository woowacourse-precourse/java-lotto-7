package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController();
        LottoResult lottoResult;

        int lottoCost = inputView.getLottoCost();
        int purchaseCount = lottoController.getLottoPurchaseCount(lottoCost);

        Lottos lottos = lottoController.generateLottos(purchaseCount);
        outputView.showMyLottos(lottos, purchaseCount);

        List<Integer> winningLotto = lottoController.splitWinningNumbers(inputView.getWinningLotto());

        int bonusNumber = inputView.getBonusNumber(winningLotto);

        lottoResult = new LottoResult(winningLotto, bonusNumber, lottoCost);
        lottoController.checkResult(lottos, lottoResult);

        double profitRate = lottoController.checkProfitRate(lottoResult);

        outputView.printStatistics(lottoResult);
        outputView.printProfitRate(profitRate);
    }
}
