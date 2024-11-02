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

public class Application {

    private static final LottoPurchaseController lottoPurchaseController = new LottoPurchaseController();
    private static final LottoWinningNumbersController lottoWinningNumbersController = new LottoWinningNumbersController();
    private static final LottoStatisticsController lottoStatisticsController = new LottoStatisticsController();

    public static void main(String[] args) {

        long userPurchaseMoney = InputView.inputPurchaseMoney();
        Lottos lottos = lottoPurchaseController.purchaseLottos(userPurchaseMoney);
        OutputView.showPurchasedLottos(lottos);

        Set<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusWinningNumber();
        LottoWinningNumbers lottoWinningNumbers = lottoWinningNumbersController.determineLottoWinningNumbers(winningNumbers, bonusNumber);

        LottoResult lottoResult = lottoStatisticsController.calculateLottoPrizes(lottos, lottoWinningNumbers, userPurchaseMoney);
        OutputView.showPurchasedLottosStatus(lottoResult);
    }
}
