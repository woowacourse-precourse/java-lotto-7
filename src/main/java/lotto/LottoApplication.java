package lotto;

import lotto.controller.LottoPurchaseController;
import lotto.controller.LottoStatisticsController;
import lotto.controller.LottoWinningNumbersController;
import lotto.domain.LottoResult;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Set;

public class LottoApplication {

    private final LottoPurchaseController lottoPurchaseController;
    private final LottoWinningNumbersController lottoWinningNumbersController;
    private final LottoStatisticsController lottoStatisticsController;

    public LottoApplication(LottoPurchaseController lottoPurchaseController,
                            LottoWinningNumbersController lottoWinningNumbersController,
                            LottoStatisticsController lottoStatisticsController) {
        this.lottoPurchaseController = lottoPurchaseController;
        this.lottoWinningNumbersController = lottoWinningNumbersController;
        this.lottoStatisticsController = lottoStatisticsController;
    }

    public void run() {
        long userPurchaseMoney = InputView.inputPurchaseMoney();
        Lottos lottos = lottoPurchaseController.purchaseLottos(userPurchaseMoney);
        OutputView.showPurchasedLottos(lottos);

        Set<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusWinningNumber(winningNumbers);
        LottoWinningNumbers lottoWinningNumbers = lottoWinningNumbersController
            .determineLottoWinningNumbers(winningNumbers, bonusNumber);

        LottoResult lottoResult = lottoStatisticsController
            .calculateLottoPrizes(lottos, lottoWinningNumbers, userPurchaseMoney);
        OutputView.showPurchasedLottosStatus(lottoResult);
    }
}
