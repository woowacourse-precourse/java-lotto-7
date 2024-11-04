package lotto;

import lotto.machine.LottoMachine;
import lotto.result.LottoRank;
import lotto.result.LottoResult;
import lotto.statistics.ProfitCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        List<Lotto> lottos = LottoMachine.generateLottos(purchaseAmount);
        OutputView.printPurchaseInfo(lottos);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);

        LottoResult lottoResult = new LottoResult(lottos, winningNumbers, bonusNumber);
        Map<LottoRank, Integer> resultStatistics = lottoResult.getStatistics();

        List<Integer> matchCounts = lottoResult.extractMatchCounts();

        OutputView.printWinningStatistics(
                matchCounts,
                ProfitCalculator.calculateProfitRate(resultStatistics, purchaseAmount)
        );
    }
}
