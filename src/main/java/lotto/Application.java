package lotto;

import lotto.common.LottoRank;
import lotto.controller.LottoGame;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        LottoGame lottoGame = new LottoGame(purchaseAmount);

        OutputView.printPurchasedLottos(lottoGame.getPurchasedLottos());

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonusNumber = InputView.inputBonusNumber();

        Map<LottoRank, Integer> result = lottoGame.calculateStatistics(winningLotto, bonusNumber);
        double totalProfit = lottoGame.calculateTotalProfit(result);
        OutputView.printStatistics(result, purchaseAmount, totalProfit);
    }
}
